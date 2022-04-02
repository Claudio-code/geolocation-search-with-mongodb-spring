package com.search.geolocationsearchwithmongodbspring.dto.skill;

import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.enuns.LevelEnum;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SkillRequestDTO {
    private Student student;
    private String skillName;
    private LevelEnum skillLevel;
}
