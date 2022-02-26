package com.search.geolocationsearchwithmongodbspring.dto.student;

import java.time.LocalDate;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentDTO {
    private String name;
    private LocalDate birthday;
    private CourseDTO course;
}
