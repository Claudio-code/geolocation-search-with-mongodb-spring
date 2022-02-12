package com.search.geolocationsearchwithmongodbspring.controller;

import com.search.geolocationsearchwithmongodbspring.exception.ApiErrors;
import com.search.geolocationsearchwithmongodbspring.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class BaseController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(MethodArgumentNotValidException validException) {
        return new ApiErrors(validException.getBindingResult());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleIsbnAlreadyUsed(BusinessException businessException) {
        return new ApiErrors(businessException);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrors> handleResponseStatusException(ResponseStatusException statusException) {
        return new ResponseEntity<>(new ApiErrors(statusException), statusException.getStatus());
    }
}
