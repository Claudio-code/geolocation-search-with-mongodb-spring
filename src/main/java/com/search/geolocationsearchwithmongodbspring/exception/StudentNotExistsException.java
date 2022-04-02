package com.search.geolocationsearchwithmongodbspring.exception;

public class StudentNotExistsException extends BusinessException {
    private static final String MESSAGE = "This student not exist";

    public StudentNotExistsException() {
        super(MESSAGE);
    }
}
