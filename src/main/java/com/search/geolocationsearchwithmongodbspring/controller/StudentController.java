package com.search.geolocationsearchwithmongodbspring.controller;

import com.search.geolocationsearchwithmongodbspring.dto.findall.ListStudentsResponseDTO;
import com.search.geolocationsearchwithmongodbspring.factory.PageableFactory;
import com.search.geolocationsearchwithmongodbspring.factory.dto.StudentDTOFactory;
import com.search.geolocationsearchwithmongodbspring.factory.dto.StudentSearchRequestDTOFactory;
import com.search.geolocationsearchwithmongodbspring.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/student")
public class StudentController extends BaseController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid StudentDTOFactory studentDTOFactory) {
        studentService.create(studentDTOFactory.make());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListStudentsResponseDTO findAll(PageableFactory pageableFactory) {
        return studentService.findAll(pageableFactory.make());
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public ListStudentsResponseDTO search(StudentSearchRequestDTOFactory studentSearchRequestDTOFactory) {
        return studentService.searchBy(studentSearchRequestDTOFactory.make());
    }
}
