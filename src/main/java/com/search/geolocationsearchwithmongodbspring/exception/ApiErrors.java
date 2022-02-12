package com.search.geolocationsearchwithmongodbspring.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Getter
public class ApiErrors {
    private final List<String> errors;

    public ApiErrors() {
        this.errors = List.of();
    }

    public ApiErrors(BindingResult bindingResult) {
        this.errors = List.of();
        bindingResult.getAllErrors()
                .forEach(error -> this.errors.add(error.getDefaultMessage()));
    }

    public ApiErrors(BusinessException exception) {
        this.errors = List.of(exception.getMessage());
    }

    public ApiErrors(ResponseStatusException statusException) {
        this.errors = List.of(Objects.requireNonNull(statusException.getMessage()));
    }
}
