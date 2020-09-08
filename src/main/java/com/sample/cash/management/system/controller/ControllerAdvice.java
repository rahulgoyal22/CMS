package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.exception.UnprocessableEntity;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ServiceResponse handleException(IllegalArgumentException ex) {
        return ServiceResponse.builder().status(Status.Failure).message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = UnprocessableEntity.class)
    public ServiceResponse handleException(UnprocessableEntity ex) {
        return ServiceResponse.builder().status(Status.Failure).message(ex.getMessage()).build();
    }
}
