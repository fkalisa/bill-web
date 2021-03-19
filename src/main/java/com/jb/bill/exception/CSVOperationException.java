package com.jb.bill.exception;

public class CSVOperationException extends RuntimeException{

    public CSVOperationException(String message, Throwable e){
        super(message, e);
    }

    public CSVOperationException(String message ){
        super(message);
    }
}
