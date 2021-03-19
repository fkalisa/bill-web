package com.jb.bill.web.service;

import com.jb.bill.web.dao.Invoice;
import com.jb.bill.web.repository.CSVInvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CSVInvoiceService implements InvoiceService {

    private final CSVInvoiceRepository csvInvoiceRepository;

    public CSVInvoiceService(CSVInvoiceRepository csvInvoiceRepository) {
        this.csvInvoiceRepository = csvInvoiceRepository;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        if (invoice == null){
            throw new IllegalArgumentException("invoice cannot be null");
        }
       return csvInvoiceRepository.createInvoice(invoice);
    }

    @Override
    public Invoice getInvoiceByUUID(UUID uuid) {
        if (uuid == null){
            throw new IllegalArgumentException("uuid cannot be null");
        }
        return csvInvoiceRepository.getInvoiceByUUID(uuid);
    }

    @Override
    public List<Invoice> getInvoicesByLogin(String login) {
      if(login ==null){
          throw new IllegalArgumentException("login cannot be null");
      }

        return csvInvoiceRepository.getInvoicesByLogin(login) ;
    }
}
