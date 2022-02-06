package com.search.geolocationsearchwithmongodbspring.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.search.geolocationsearchwithmongodbspring.enuns.LevelEnum;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "skills")
public class Skill {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private String name;
    private LevelEnum level;
}
