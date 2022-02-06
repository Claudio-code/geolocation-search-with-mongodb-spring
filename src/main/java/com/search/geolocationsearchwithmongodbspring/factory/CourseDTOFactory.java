package com.search.geolocationsearchwithmongodbspring.factory;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;

public class CourseDTOFactory implements FactoryInterface<CourseDTO> {
    private String name;

    public CourseDTOFactory(String name) {
        this.name = name;
    }

    @Override
    public CourseDTO make() {
        return CourseDTO.builder()
            .name(name)
            .build();
    }
}
