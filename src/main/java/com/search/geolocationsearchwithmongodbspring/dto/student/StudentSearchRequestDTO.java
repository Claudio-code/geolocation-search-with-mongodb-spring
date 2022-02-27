package com.search.geolocationsearchwithmongodbspring.dto.student;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@Builder
@Getter
public class StudentSearchRequestDTO {
    private String name;
    private String cacheKey;
    private Pageable pageable;
}
