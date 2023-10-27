package com.sample.controller.aspect;

import com.sample.common.model.exception.BusinessException;
import com.sample.controller.controller.CustomerResource;
import com.sample.controller.controller.ManagerResource;
import com.sample.controller.converter.RequestResponseMapper;
import com.sample.controller.dto.exception.ErrorCodeDTO;
import com.sample.controller.dto.exception.ExceptionInfoDTO;
import com.sample.controller.dto.exception.ValidationExceptionInfoDTO;
import com.sample.controller.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice(assignableTypes = {CustomerResource.class, ManagerResource.class})
public class ControllerExceptionHandler {

    private final RequestResponseMapper mapper;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExceptionInfoDTO exception(MethodArgumentNotValidException exception) {
        return Validator.createValidationServiceException(exception.getBindingResult());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionInfoDTO exception(BusinessException exception) {
        return new ExceptionInfoDTO(mapper.toErrorCodeDTO(exception.getErrorCode()), exception.getMessage());
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionInfoDTO exception(Throwable exception) {
        return new ExceptionInfoDTO(ErrorCodeDTO.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
