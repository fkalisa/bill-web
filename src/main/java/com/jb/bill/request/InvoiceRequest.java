package com.jb.bill.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class InvoiceRequest {

    @NotEmpty(message = "eventNumber should not be empty")
    private String eventNumber;
    @NotEmpty(message = "branch should not be empty")
    private String branch;
    @NotEmpty(message = "login should not be empty")
    private String login;
    @Email(message = "email should be valid")
    private String email;
    private LocalDateTime localDateTime;


    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
