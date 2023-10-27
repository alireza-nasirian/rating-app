package com.sample.controller.dto;

import com.sample.controller.dto.exception.ValidationExceptionInfoDTO;

import java.util.HashMap;

public class ResponseBuilder {

    public static ValidationExceptionInfoDTO getEmptyDeliveryIdException() {
        String message = "Validation Exception";
        HashMap<String, String> errorParam = new HashMap<>();
        errorParam.put("deliveryId", "Is Empty");
        return new ValidationExceptionInfoDTO(message, errorParam);
    }
}
