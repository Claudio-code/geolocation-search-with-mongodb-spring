package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.student.StudentDTO;
import com.search.geolocationsearchwithmongodbspring.dto.findall.ListStudentsResponseDTO;
import com.search.geolocationsearchwithmongodbspring.exception.StudentAlreadyExistsException;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import com.search.geolocationsearchwithmongodbspring.util.StudentCreateUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class StudentServiceTest extends StudentCreateUtil {
    @MockBean
    StudentRepository studentRepository;
    StudentService studentService;

    @BeforeEach
    void setUp() {
        final ValidateService validateService = new ValidateService(studentRepository);
        studentService = new StudentService(studentRepository, validateService);
    }

    @Test
    void shouldCreateNewStudentWithErrorIfIsStudentExist() {
        final StudentDTO studentDTO = makeStudentDTOWithCourseDTO();
        Mockito.when(studentRepository.exists(Mockito.any())).thenReturn(true);
        Throwable exception = Assertions.catchThrowable(() -> studentService.create(studentDTO));

        assertThat(exception)
                .isInstanceOf(StudentAlreadyExistsException.class)
                .hasMessage("This student already exist.");
    }

    @Test
    void shouldReturnEmptyListIfStudentNotExist() {
        final Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(studentRepository.findAll()).thenReturn(List.of());
        final ListStudentsResponseDTO listStudentsResponseDTO = studentService.findAll(pageable);

        assertThat(listStudentsResponseDTO.getHasMore()).isFalse();
        assertThat(listStudentsResponseDTO.getPage()).isEqualTo(pageable.getPageNumber());
        assertThat(listStudentsResponseDTO.getSize()).isEqualTo(pageable.getPageSize());
        assertThat(listStudentsResponseDTO.getStudentResponseDTO()).isEmpty();
    }

    @Test
    void shouldReturnFiveStudentInList() {
        final Pageable pageable = PageRequest.of(0, 2);
        Mockito.when(studentRepository.findAll()).thenReturn(makeListWithFiveStudents());
        final ListStudentsResponseDTO listStudentsResponseDTO = studentService.findAll(pageable);

        assertThat(listStudentsResponseDTO.getHasMore()).isTrue();
        assertThat(listStudentsResponseDTO.getPage()).isEqualTo(pageable.getPageNumber());
        assertThat(listStudentsResponseDTO.getSize()).isEqualTo(pageable.getPageSize());
    }
}
