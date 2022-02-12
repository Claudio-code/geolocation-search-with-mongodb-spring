package com.search.geolocationsearchwithmongodbspring.exception;

public class StudentAlreadyExistsException extends BusinessException {
    private static final String MESSAGE = "Is student already exist.";

    public StudentAlreadyExistsException() {
        super(MESSAGE);
    }
}
