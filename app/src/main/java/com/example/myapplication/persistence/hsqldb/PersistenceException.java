package com.example.myapplication.persistence.hsqldb;

public class PersistenceException extends RuntimeException {

    public PersistenceException(final Exception cause) {
        super(cause);
    }
}
