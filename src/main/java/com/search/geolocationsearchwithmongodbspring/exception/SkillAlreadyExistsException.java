package com.search.geolocationsearchwithmongodbspring.exception;

public class SkillAlreadyExistsException extends BusinessException {
    private static final String MESSAGE = "This skill already exist.";

    public SkillAlreadyExistsException() {
        super(MESSAGE);
    }
}
