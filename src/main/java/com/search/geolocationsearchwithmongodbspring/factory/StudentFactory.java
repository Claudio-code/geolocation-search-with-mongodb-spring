package com.search.geolocationsearchwithmongodbspring.factory;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;
import com.search.geolocationsearchwithmongodbspring.dto.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Course;
import com.search.geolocationsearchwithmongodbspring.entity.Student;

public record StudentFactory(StudentDTO studentDTO) implements FactoryInterface<Student> {
    @Override
    public Student make() {
        CourseDTO courseDTO = studentDTO.getCourse();
        Course course = Course.builder()
                .name(courseDTO.getName())
                .build();
        return Student.builder()
                .name(studentDTO.getName())
                .birthday(studentDTO.getBirthday())
                .course(course)
                .build();
    }
}
