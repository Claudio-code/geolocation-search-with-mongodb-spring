package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.factory.StudentFactory;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record StudentService(StudentRepository studentRepository) {
    public void create(StudentDTO studentDTO) {
        StudentFactory studentFactory = new StudentFactory(studentDTO);
        Student student = studentFactory.make();
        studentRepository.save(student);
    }

    public Page<Student> findAll(Pageable pageable) {
        List<Student> allStudents = studentRepository.findAll();
        return new PageImpl<>(allStudents, pageable, allStudents.size());
    }
}
