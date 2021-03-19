package com.jb.bill.web.util;

public enum CSVHeaders {

    ID("ID"), BRANCH("Branch"),
    EVENT_NUMBER("EventNumber"), EMAIL("Email"),
    LOGIN("login"), TIME_STAMP("Timestamp");

    private String name;

    CSVHeaders(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
