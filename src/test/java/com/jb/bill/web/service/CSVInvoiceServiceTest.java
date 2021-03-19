package com.jb.bill.web.service;

import com.jb.bill.web.dao.Invoice;
import com.jb.bill.web.repository.CSVInvoiceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CSVInvoiceServiceTest {

    @Mock
    CSVInvoiceRepository csvInvoiceRepository;

    CSVInvoiceService csvInvoiceService = new CSVInvoiceService(csvInvoiceRepository);

    private static Invoice invoice;

    @BeforeAll
    static void init() {

        UUID uuid = UUID.randomUUID();
        String branch = "1";
        String eventNumber = "185000-I-2021-03";
        String login = "u24999";
        String email = "u24999@test.com";
        Date date = new Date();
        invoice = new Invoice(uuid, branch, eventNumber, login, email,date);
    }

    @Test
    public void shouldCreateInvoiceThrowIllegalArgumentException(){

        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()->{csvInvoiceService.createInvoice(null);} );
        assertEquals("invoice cannot be null", exception.getMessage());

    }

    @Test
    public void shouldCreateInvoice(){



        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()->{csvInvoiceService.createInvoice(null);} );
        assertEquals("invoice cannot be null", exception.getMessage());

    }
}
