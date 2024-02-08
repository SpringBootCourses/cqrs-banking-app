package com.example.cqrsbankingapp.web.controller;

import com.example.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String resourceNotFound(
            final ResourceNotFoundException e
    ) {
        return e.getMessage() != null ? e.getMessage() : "Not found.";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(
            final Exception e
    ) {
        e.printStackTrace();
        return "Server error.";
    }

}
