package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.student.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.dto.findall.ListStudentsResponseDTO;
import com.search.geolocationsearchwithmongodbspring.dto.student.StudentSearchRequestDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.exception.StudentAlreadyExistsException;
import com.search.geolocationsearchwithmongodbspring.exception.StudentNotExistsException;
import com.search.geolocationsearchwithmongodbspring.factory.StudentFactory;
import com.search.geolocationsearchwithmongodbspring.factory.dto.ListStudentsResponseDTOFactory;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;

import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private static final String CACHE_KEY = "student";
    private final StudentRepository studentRepository;
    private final ValidateService validateService;

    public void create(StudentDTO studentDTO) {
        final StudentFactory studentFactory = new StudentFactory(studentDTO);
        final Student student = studentFactory.make();
        if (validateService.verifyIfStudentExist(student)) {
            throw new StudentAlreadyExistsException();
        }
        studentRepository.save(student);
    }

    @CachePut(cacheNames = CACHE_KEY, key = "#pageable.getPageNumber()-#pageable.getPageSize()")
    public ListStudentsResponseDTO findAll(Pageable pageable) {
        return ListStudentsResponseDTOFactory.builder()
                .listStudents(studentRepository.findAll())
                .pageable(pageable)
                .build()
                .make();
    }

    public Student findOne(Student student) {
        final Example<Student> studentExample = Example.of(student);
        final Optional<Student> optionalStudent = studentRepository.findOne(studentExample);
        if (optionalStudent.isEmpty()) {
            throw new StudentNotExistsException();
        }
        return optionalStudent.get();
    }

    public void searchBy(StudentSearchRequestDTO studentSearchRequestDTO) {
        studentRepository.findAllBy(studentSearchRequestDTO.getName()).forEach(student -> System.out.println(student.name()));
    }
}
