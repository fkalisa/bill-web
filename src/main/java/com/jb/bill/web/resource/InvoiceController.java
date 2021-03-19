package com.jb.bill.web.resource;

import com.jb.bill.web.dao.Invoice;
import com.jb.bill.web.request.InvoiceRequest;
import com.jb.bill.web.service.InvoiceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @ApiOperation("Add an invoice")
    @PostMapping
    public Invoice createInvoice(@RequestBody @Valid InvoiceRequest invoiceRequest){
        Invoice invoice = new Invoice(UUID.randomUUID(),invoiceRequest.getBranch(), invoiceRequest.getEventNumber(), invoiceRequest.getLogin(), invoiceRequest.getEmail(), new Date());
        return invoiceService.createInvoice(invoice);
    }

    @ApiOperation("Get an invoice by UUID")
    @GetMapping("/{uuid}")
    public Invoice getInvoiceByUUID(@PathVariable UUID uuid) {
        return invoiceService.getInvoiceByUUID(uuid);
    }

    @ApiOperation("Get invoices by login")
    @GetMapping
    public List<Invoice> getInvoicesByLogin(@RequestParam String login) {
        return invoiceService.getInvoicesByLogin(login);
    }

    @ApiOperation("Update invoice by UUID")
    @PutMapping("/{uuid}")
    public void updateInvoiceByUUID(@PathVariable UUID uuid, InvoiceRequest invoiceRequest){

    }

    @ApiOperation("Delete invoice by UUID")
    @DeleteMapping("/{uuid}")
    public void deleteInvoiceByUUID(@PathVariable UUID uuid){

    }
}
