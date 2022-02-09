package com.search.geolocationsearchwithmongodbspring.controller;

import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.factory.PageableFactory;
import com.search.geolocationsearchwithmongodbspring.factory.dto.StudentDTOFactory;
import com.search.geolocationsearchwithmongodbspring.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid StudentDTOFactory studentDTOFactory) {
        studentService.create(studentDTOFactory.make());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Student> findAll(PageableFactory pageableFactory) {
        var allStudents = studentService.findAll(pageableFactory.make());

        return allStudents;
    }
}
