package com.example.cqrsbankingapp.web.controller;

import com.example.cqrsbankingapp.domain.exception.ResourceAlreadyExistsException;
import com.example.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.example.cqrsbankingapp.web.dto.MessageDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageDto resourceNotFound(
            final ResourceNotFoundException e
    ) {
        return new MessageDto(e.getMessage() != null
                ? e.getMessage()
                : "Not found."
        );
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto resourceAlreadyExists(
            final ResourceAlreadyExistsException e
    ) {
        return new MessageDto(e.getMessage() != null
                ? e.getMessage()
                : "Already exists."
        );
    }

    @ExceptionHandler({
            BadCredentialsException.class,
            InternalAuthenticationServiceException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto badCredentials(
            final RuntimeException e
    ) {
        return new MessageDto("Authentication failed.");
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto accessDenied(
            final AccessDeniedException e
    ) {
        return new MessageDto("Access denied.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public MessageDto validationException(
            final MethodArgumentNotValidException e
    ) {
        Map<String, String> errors = e.getBindingResult()
                .getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        DefaultMessageSourceResolvable::getDefaultMessage
                ));
        return new MessageDto(
                "Validation failed.",
                errors
        );
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto illegalState(
            final IllegalStateException e
    ) {
        return new MessageDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageDto exception(
            final Exception e
    ) {
        e.printStackTrace();
        return new MessageDto("Server error.");
    }

}
