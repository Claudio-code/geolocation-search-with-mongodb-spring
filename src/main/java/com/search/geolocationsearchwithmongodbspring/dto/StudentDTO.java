package com.search.geolocationsearchwithmongodbspring.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentDTO {
    private String name;
    private LocalDate birthday;
    private CourseDTO course;
}
