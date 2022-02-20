package com.search.geolocationsearchwithmongodbspring.util;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;
import com.search.geolocationsearchwithmongodbspring.dto.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Course;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

public abstract class StudentCreateUtil {
    protected StudentDTO makeStudentDTOWithCourseDTO() {
        final CourseDTO courseDTO = CourseDTO.builder()
                .name("math")
                .build();
        return StudentDTO.builder()
                .name("myName")
                .course(courseDTO)
                .birthday(LocalDate.now())
                .build();
    }

    protected List<Student> makeListWithFiveStudents() {
        return List.of(
                makeStudent(),
                makeStudent(),
                makeStudent(),
                makeStudent()
        );
    }


    private Student makeStudent() {
        final Course course = Course.builder()
                .name("art")
                .build();
        return Student.builder()
                .name("test")
                .birthday(LocalDate.now())
                .course(course)
                .build();
    }
}
