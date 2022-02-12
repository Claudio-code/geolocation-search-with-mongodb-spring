package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.findall.ListStudentsResponseDTO;
import com.search.geolocationsearchwithmongodbspring.dto.findall.StudentResponseDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Builder
public class ListStudentsResponseDTOFactory implements FactoryInterface<ListStudentsResponseDTO> {
    private List<Student> listStudents;
    private Pageable pageable;

    @Override
    public ListStudentsResponseDTO make() {
        final Page<Student> studentPage = getListPageableOfStudent();
        final List<StudentResponseDTO> studentResponseDTOList = studentPage.stream()
                .map(this::transformListStudentToListStudentResponseDTO)
                .toList();
        return ListStudentsResponseDTO.builder()
                .size(pageable.getPageSize())
                .hasMore(studentPage.hasNext())
                .page(pageable.getPageNumber())
                .studentResponseDTO(studentResponseDTOList)
                .build();
    }

    private StudentResponseDTO transformListStudentToListStudentResponseDTO(Student student) {
        return StudentResponseDTOFactory.builder()
                .student(student)
                .build()
                .make();
    }

    private Page<Student> getListPageableOfStudent() {
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), listStudents.size());
        try {
            return new PageImpl<>(listStudents.subList(start, end), pageable, listStudents.size());
        } catch (IllegalArgumentException illegalArgumentException) {
            return new PageImpl<>(List.of(), pageable, listStudents.size());
        }
    }
}
