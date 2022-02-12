package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.skill.SkillRequestDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.enuns.LevelEnum;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class SkillRequestDTOFactory implements FactoryInterface<SkillRequestDTO> {
    private String studentId;
    private String skillName;
    private String skillLevel;

    @Override
    public SkillRequestDTO make() {
        final LevelEnum level = LevelEnum.valueOf(skillLevel);
        final Student student = Student.builder()
                .id(studentId)
                .build();
        return SkillRequestDTO.builder()
                .student(student)
                .skillName(skillName)
                .skillLevel(level)
                .build();
    }
}
