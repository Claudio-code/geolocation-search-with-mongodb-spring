package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.student.StudentSearchRequestDTO;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.Builder;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Builder
public class StudentSearchRequestDTOFactory implements FactoryInterface<StudentSearchRequestDTO> {
    private String name;
    private Integer page;
    private Integer size;

    @Override
    public StudentSearchRequestDTO make() {
        validatePageable();
        return StudentSearchRequestDTO.builder()
                .name(name)
                .pageable(PageRequest.of(page, size))
                .cacheKey(formatterCacheKey())
                .build();
    }

    private void validatePageable() {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
    }

    private String formatterCacheKey() {
        return String.format("%s-%s-%s", name, page, size);
    }
}
