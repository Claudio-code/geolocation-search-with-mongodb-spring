package com.search.geolocationsearchwithmongodbspring.dto.findall;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ListStudentsResponseDTO {
    private Boolean hasMore;
    private Integer page;
    private Integer size;
    private List<StudentResponseDTO> studentResponseDTO;
}
