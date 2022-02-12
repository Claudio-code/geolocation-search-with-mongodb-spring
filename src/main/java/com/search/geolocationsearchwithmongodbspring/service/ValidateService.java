package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ValidateService {
    private final StudentRepository studentRepository;

    public Boolean verifyIfStudentExist(Student student) {
        final Example<Student> studentExample = Example.of(student);
        final Optional<Student> optionalStudent = studentRepository.findOne(studentExample);
        return optionalStudent.isPresent();
    }
}
