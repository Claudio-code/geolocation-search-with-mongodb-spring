package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.skill.SkillRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SkillService {
    private final StudentService studentService;

    public void create(SkillRequestDTO skillRequestDTO) {

    }
}
