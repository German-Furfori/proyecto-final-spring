package com.ayi.spring.rest.serv.app.exceptions;

import java.sql.SQLException;

public class DataBaseException extends SQLException {
    public DataBaseException(String message) {
        super(message);
    }
}
