package com.search.geolocationsearchwithmongodbspring.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Builder
@Document(collection = "students")
public class Student {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private String name;
    private LocalDate birthday;
    private Course course;
    private List<Note> notes;
    private List<Skill> skills;
}
