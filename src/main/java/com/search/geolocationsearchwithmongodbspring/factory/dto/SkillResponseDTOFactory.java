package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.findall.SkillResponseDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Skill;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SkillResponseDTOFactory implements FactoryInterface<SkillResponseDTO> {
    private Skill skill;

    @Override
    public SkillResponseDTO make() {
        return SkillResponseDTO
                .builder()
                .name(skill.name())
                .level(skill.level().name())
                .build();
    }
}
