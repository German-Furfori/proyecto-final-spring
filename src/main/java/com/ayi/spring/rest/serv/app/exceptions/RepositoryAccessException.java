package com.ayi.spring.rest.serv.app.exceptions;

public class RepositoryAccessException extends RuntimeException {
    public RepositoryAccessException(String message) {
        super(message);
    }
}
