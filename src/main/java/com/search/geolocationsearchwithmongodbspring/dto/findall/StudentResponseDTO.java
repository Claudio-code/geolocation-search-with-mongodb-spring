package com.search.geolocationsearchwithmongodbspring.dto.findall;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class StudentResponseDTO {
    private String name;
    private LocalDate birthday;
    private CourseDTO course;
}
