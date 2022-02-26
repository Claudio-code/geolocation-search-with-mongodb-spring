package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.student.StudentSearchRequestDTO;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.Builder;

@Builder
public class StudentSearchRequestDTOFactory implements FactoryInterface<StudentSearchRequestDTO> {
    private String name;

    @Override
    public StudentSearchRequestDTO make() {
        return StudentSearchRequestDTO.builder()
                .name(name)
                .build();
    }
}
