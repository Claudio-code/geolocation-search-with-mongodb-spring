package com.search.geolocationsearchwithmongodbspring.factory;

import com.search.geolocationsearchwithmongodbspring.dto.skill.SkillRequestDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Skill;
import lombok.Builder;

@Builder
public class SkillFactory implements FactoryInterface<Skill> {
    private SkillRequestDTO skillRequestDTO;

    @Override
    public Skill make() {
        return Skill.builder()
                .name(skillRequestDTO.getSkillName())
                .level(skillRequestDTO.getSkillLevel())
                .build();
    }
}
