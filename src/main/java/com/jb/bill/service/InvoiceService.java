package com.jb.bill.service;

import com.jb.bill.dao.Invoice;

import java.util.List;
import java.util.UUID;

public interface InvoiceService {
    Invoice createInvoice(Invoice invoice);

    Invoice getInvoiceByUUID(UUID uuid);

    List<Invoice> getInvoicesByLogin(String login);
}
