package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.dto.findall.ListStudentsResponseDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.exception.StudentAlreadyExistsException;
import com.search.geolocationsearchwithmongodbspring.factory.StudentFactory;
import com.search.geolocationsearchwithmongodbspring.factory.dto.ListStudentsResponseDTOFactory;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;

import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

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
}
