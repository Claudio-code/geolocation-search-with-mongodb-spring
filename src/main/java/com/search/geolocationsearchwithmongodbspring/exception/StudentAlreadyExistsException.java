package com.search.geolocationsearchwithmongodbspring.exception;

public class StudentAlreadyExistsException extends BusinessException {
    private static final String MESSAGE = "This student already exist.";

    public StudentAlreadyExistsException() {
        super(MESSAGE);
    }
}
