package com.sample.controller.dto.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValidationExceptionInfoDTO extends ExceptionInfoDTO {

    private Map<String, String> errorParam;

    public ValidationExceptionInfoDTO(String message, Object errorParam) {
        super(ErrorCodeDTO.INVALID_INPUT, message);
        this.errorParam = (Map<String, String>)errorParam;
    }
}
