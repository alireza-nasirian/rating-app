package com.sample.controller.dto.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExceptionInfoDTO {

    @Schema(description = "error code")
    private ErrorCodeDTO errorCode;

    @Schema(description = "message of error")
    private String message;

    public ExceptionInfoDTO(ErrorCodeDTO errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ExceptionInfoDTO() {
    }

}
