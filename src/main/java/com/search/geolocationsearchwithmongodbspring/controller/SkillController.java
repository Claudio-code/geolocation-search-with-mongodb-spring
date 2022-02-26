package com.search.geolocationsearchwithmongodbspring.controller;

import com.search.geolocationsearchwithmongodbspring.factory.dto.SkillRequestDTOFactory;
import com.search.geolocationsearchwithmongodbspring.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/skill")
public class SkillController extends BaseController {
    private final SkillService skillService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid SkillRequestDTOFactory skillRequestDTOFactory) {
        skillService.create(skillRequestDTOFactory.make());
    }
}
