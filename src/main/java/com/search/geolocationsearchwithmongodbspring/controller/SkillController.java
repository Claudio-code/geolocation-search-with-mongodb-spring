package com.search.geolocationsearchwithmongodbspring.controller;

import com.search.geolocationsearchwithmongodbspring.dto.skill.SkillRequestDTO;
import com.search.geolocationsearchwithmongodbspring.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/skill")
public class SkillController extends BaseController {
    private final SkillService skillService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(SkillRequestDTO skillRequestDTO) {
    }
}
