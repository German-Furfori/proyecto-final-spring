package com.ayi.spring.rest.serv.app.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.ayi.spring.rest.serv.app.constants.ExceptionStrings.*;
import static com.ayi.spring.rest.serv.app.constants.HashMapStrings.ERROR_CODE;
import static com.ayi.spring.rest.serv.app.constants.HashMapStrings.ERROR_MESSAGE;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runTimeExceptionHandler() {

        Map<String, Object> responseException = new HashMap<>();

        responseException.put(ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseException.put(ERROR_MESSAGE, GLOBAL_ERROR);

        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException() {

        Map<String, Object> responseException = new HashMap<>();

        responseException.put(ERROR_CODE, HttpStatus.BAD_REQUEST.value());
        responseException.put(ERROR_MESSAGE, NOT_NULL_PROPERTY);

        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> dataIntegrityViolationExceptionHandler() {

        Map<String, Object> responseException = new HashMap<>();

        responseException.put(ERROR_CODE, HttpStatus.BAD_REQUEST.value());
        responseException.put(ERROR_MESSAGE, READ_ACCESS_EXCEPTION_INCORRECT_INPUT);

        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }

}
