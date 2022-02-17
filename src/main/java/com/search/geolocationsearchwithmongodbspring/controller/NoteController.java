package com.search.geolocationsearchwithmongodbspring.controller;

import com.search.geolocationsearchwithmongodbspring.factory.dto.NoteRequestDTOFactory;
import com.search.geolocationsearchwithmongodbspring.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/note")
public class NoteController extends BaseController {
    private NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid NoteRequestDTOFactory noteRequestDTOFactory) {
        noteService.create(noteRequestDTOFactory.make());
    }
}
