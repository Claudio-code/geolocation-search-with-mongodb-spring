package com.search.geolocationsearchwithmongodbspring.dto.findall;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SkillResponseDTO {
    private String name;
    private String level;
}
