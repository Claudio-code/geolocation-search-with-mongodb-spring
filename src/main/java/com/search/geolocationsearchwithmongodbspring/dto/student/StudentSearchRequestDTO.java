package com.search.geolocationsearchwithmongodbspring.dto.student;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentSearchRequestDTO {
    private String name;
}
