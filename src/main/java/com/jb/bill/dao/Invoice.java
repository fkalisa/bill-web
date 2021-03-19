package com.jb.bill.dao;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Invoice implements Serializable {
    @CsvBindByPosition(position = 0)
    private String invoiceUUID;
    @CsvBindByPosition(position = 1,required = true)
    private String branch;
    @CsvBindByPosition(position = 2, required = true)
    private String eventNumber;
    @CsvBindByPosition(position = 3, required = true)
    private String login;
    @CsvBindByPosition(position = 4,required = true)
    private String email;
    @CsvBindByPosition(position = 5)
    @CsvDate
    private Date date;

    public Invoice() {
    }

    public Invoice(UUID  uuid, String branch, String eventNumber, String login, String email, Date date) {
        this.invoiceUUID = uuid.toString();
        this.branch = branch;
        this.eventNumber = eventNumber;
        this.login = login;
        this.email = email;
        this.date = date;
    }

    public String getInvoiceUUID() {
        return invoiceUUID;
    }

    public void setInvoiceUUID(String invoiceUUID) {
        this.invoiceUUID = invoiceUUID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceUUID=" + invoiceUUID +
                ", branch='" + branch + '\'' +
                ", eventNumber='" + eventNumber + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceUUID, invoice.invoiceUUID) && Objects.equals(branch, invoice.branch) && Objects.equals(eventNumber, invoice.eventNumber) && Objects.equals(login, invoice.login) && Objects.equals(email, invoice.email) && Objects.equals(date, invoice.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceUUID, branch, eventNumber, login, email, date);
    }
}
