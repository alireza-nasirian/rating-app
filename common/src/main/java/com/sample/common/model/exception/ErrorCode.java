package com.sample.common.model.exception;

public enum ErrorCode {

    BIKER_NOT_FOUND("no biker found with given ID"),
    DELIVERY_NOT_FOUND("no delivery found with given ID"),
    INVALID_INPUT("invalid input"),
    INTERNAL_SERVER_ERROR("internal server error");

    private final String defaultMessage;

    ErrorCode(String message) {
        this.defaultMessage = message;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
