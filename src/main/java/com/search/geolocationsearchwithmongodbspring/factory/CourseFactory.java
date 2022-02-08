package com.search.geolocationsearchwithmongodbspring.factory;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Course;

public record CourseFactory(CourseDTO courseDTO) implements FactoryInterface<Course> {
    @Override
    public Course make() {
        return Course.builder()
            .name(courseDTO.getName())
            .build();
    }
}
