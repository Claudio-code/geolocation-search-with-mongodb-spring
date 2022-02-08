package com.search.geolocationsearchwithmongodbspring.factory;

import com.search.geolocationsearchwithmongodbspring.dto.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;

public record StudentFactory(StudentDTO studentDTO) implements FactoryInterface<Student> {
    @Override
    public Student make() {
        CourseFactory courseFactory = new CourseFactory(studentDTO.getCourse());
        return Student.builder()
                .name(studentDTO.getName())
                .birthday(studentDTO.getBirthday())
                .course(courseFactory.make())
                .build();
    }
}
