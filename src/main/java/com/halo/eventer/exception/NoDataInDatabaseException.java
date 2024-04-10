package com.halo.eventer.exception;

public class NoDataInDatabaseException extends RuntimeException{
    public NoDataInDatabaseException(String message) {
        super(message);
    }
}
