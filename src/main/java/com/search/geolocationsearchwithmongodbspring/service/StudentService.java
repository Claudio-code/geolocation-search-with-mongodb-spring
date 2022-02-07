package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.factory.StudentFactory;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public record StudentService(StudentRepository studentRepository) {
    public void create(StudentDTO studentDTO) {
        StudentFactory studentFactory = new StudentFactory(studentDTO);
        Student student = studentFactory.make();
        studentRepository.save(student);
    }
}
