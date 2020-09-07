package com.sample.cash.management.system.exception;

public class UnprocessableEntity extends RuntimeException {
    public UnprocessableEntity(String msg) {
        super(msg);
    }
}
