package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.findall.StudentResponseDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.Builder;

@Builder
public class StudentResponseDTOFactory implements FactoryInterface<StudentResponseDTO> {
    private Student student;

    @Override
    public StudentResponseDTO make() {
        CourseDTOFactory courseDTOFactory = new CourseDTOFactory(student.course().name());
        return StudentResponseDTO.builder()
                .name(student.name())
                .birthday(student.birthday())
                .course(courseDTOFactory.make())
                .build();
    }
}
