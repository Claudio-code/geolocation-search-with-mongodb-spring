package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;

public record CourseDTOFactory(String name) implements FactoryInterface<CourseDTO> {
    @Override
    public CourseDTO make() {
        return CourseDTO.builder()
                .name(name)
                .build();
    }
}
