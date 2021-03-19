package com.jb.bill.repository;

import com.jb.bill.config.FilesProperties;
import com.jb.bill.dao.Invoice;
import com.jb.bill.exception.CSVOperationException;
import com.jb.bill.exception.InvoiceNotFoundException;
import com.jb.bill.util.CSVUtil;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.nio.file.Files.createDirectories;
import static java.nio.file.Files.createFile;

@Repository
public class CSVInvoiceRepository {

    private static final Logger logger = LoggerFactory.getLogger(CSVInvoiceRepository.class);

    private static final ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();

    private FilesProperties filesProperties;

    public CSVInvoiceRepository(FilesProperties filesProperties) {
       this.filesProperties = filesProperties;
        this.initCSV();

    }


   public void initCSV() {
      Path fullPath = Path.of(filesProperties.getPath(), CSVUtil.FILE_NAME);
      logger.info(String.format("The full path where CSV files are locates %s", fullPath));
       strategy.setType(Invoice.class);
       strategy.setColumnMapping(new String[] {"invoiceUUID", "branch", "eventNumber", "login","email","localDateTime"});

       if (!Files.exists(fullPath)) {
           try {
               createDirectories(fullPath.getParent());
               createFile(fullPath);
           } catch (IOException e) {
               logger.error(String.format("Unable to create the CSV file : %s", fullPath), e);
               throw new CSVOperationException(String.format("Unable to create the CSV file : %s", fullPath), e);
           }
       }
   }

    public Invoice createInvoice(Invoice invoice) {
        if (invoice == null){
            return null;
        }
        Path fullPath = Path.of(filesProperties.getPath(), CSVUtil.FILE_NAME);
        try (Writer writer = new FileWriter(fullPath.toFile(), true)){
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withMappingStrategy(strategy)
                    .build();
            beanToCsv.write(invoice);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            logger.error("Unable to create an invoice",e);
            throw new CSVOperationException("Unable to create an invoice", e);
        }
        return invoice;
    }

    public Invoice getInvoiceByUUID(UUID uuid) {
        if(uuid ==null){
            return null;
        }
        List<Invoice> invoices = getInvoices();
        return invoices.stream()
                .filter(in ->uuid.equals(UUID.fromString(in.getInvoiceUUID())))
                .findFirst()
                .orElseThrow(()->new InvoiceNotFoundException(String.format("Unable to get invoice with uuid %s", uuid)));

    }

    public List<Invoice> getInvoicesByLogin(String login) {
        List<Invoice> list= new ArrayList<>();
        if(login ==null ){
            return list;
        }
        List<Invoice> invoices = getInvoices();

        return invoices.stream()
                .filter(invoice -> login.equals(invoice.getLogin())).collect(Collectors.toList());
    }

    private List<Invoice> getInvoices() {
        List<Invoice> invoices;

        Path fullPath = Path.of(filesProperties.getPath(), CSVUtil.FILE_NAME);

        try (Reader reader = Files.newBufferedReader(fullPath);) {
            CsvToBean cb = new CsvToBeanBuilder(reader)
                    .withType(Invoice.class)
                    .withMappingStrategy(strategy)
                    .build();
             invoices = cb.parse();

        }catch (IOException e){

            logger.error(String.format("Unable to read the CSV file : %s", e));
            throw new CSVOperationException(String.format("Unable to read the CSV file : %s", e));
        }
        return invoices;
    }
}
