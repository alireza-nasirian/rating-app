package com.sample.controller.util;

import com.sample.controller.dto.exception.ValidationExceptionInfoDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Validator {

    public static final String LENGTH = "Size";
    public static final String PATTERN = "Pattern";
    public static final String EMPTY = "NotEmpty";
    public static final String NOTNULL = "NotNull";
    public static final String NOT_BLANK = "NotBlank";
    public static final String DECIMAL_MIN = "DecimalMin";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String DIGITS = "Digits";
    public static final String Conditional = "Conditional";
    public static final String IDENTITY_VALIDATION = "IdentityValidation";
    public static final String RANGE_VALIDATION = "RangeValidation";
    public static final String NOTNULL_IF_ANOTHER_FIELD_HAS_VALUE = "NotNullIfAnotherFieldHasValue";

    public static ValidationExceptionInfoDTO createValidationServiceException(BindingResult bindingResult) {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.isEmpty()) {
            return new ValidationExceptionInfoDTO("null or empty binding result", null);
        }
        Map<String, List<String>> fieldToErrorCodeMap = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            if (fieldToErrorCodeMap.get(fieldError.getField()) == null) {
                List<String> fieldErrorCodes = new ArrayList<>();
                fieldErrorCodes.add(fieldError.getCode());
                fieldToErrorCodeMap.put(fieldError.getField(), fieldErrorCodes);
            } else {
                fieldToErrorCodeMap.get(fieldError.getField()).add(fieldError.getCode());
            }
        }

        Map<String, String> validationResponseDtos = new HashMap<>();
        for (String key : fieldToErrorCodeMap.keySet()) {
            validationResponseDtos.put(key, getDefaultMessage(fieldToErrorCodeMap.get(key)));
        }

        return new ValidationExceptionInfoDTO("Validation Exception", validationResponseDtos);
    }

    private static String getDefaultMessage(List<String> codes) {
        if (!CollectionUtils.isEmpty(codes)) {
            if (codes.contains(Validator.NOTNULL)) {
                return "Is Null";
            }
            if (codes.contains(Validator.EMPTY)) {
                return "Is Empty";
            }
            if (codes.contains(Validator.NOT_BLANK)) {
                return "Is Empty";
            }
            if (codes.contains(Validator.LENGTH)) {
                return "Invalid Length";
            }
            if (codes.contains(Validator.DIGITS)) {
                return "Invalid Digits/Length";
            }
            if (codes.contains(Validator.PATTERN)) {
                return "Invalid Pattern";
            }
            if (codes.contains(Validator.DECIMAL_MIN)) {
                return "Is Lower Than Min Value";
            }
            if (codes.contains(Validator.Conditional)) {
                return "Is Empty";
            }
            if (codes.contains(Validator.IDENTITY_VALIDATION)) {
                return "Invalid Identity";
            }
            if (codes.contains(Validator.RANGE_VALIDATION)) {
                return "Invalid Range";
            }
            if (codes.contains(Validator.NOTNULL_IF_ANOTHER_FIELD_HAS_VALUE))
                return "Is Null";
        }
        return "Bad Input";
    }
}
