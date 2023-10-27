package com.sample.controller.dto.exception;

public enum ErrorCodeDTO {

    BIKER_NOT_FOUND("no biker found with given ID"),
    INVALID_INPUT("invalid input"),
    INTERNAL_SERVER_ERROR("internal server error");

    private final String defaultMessage;

    ErrorCodeDTO(String message) {
        this.defaultMessage = message;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
