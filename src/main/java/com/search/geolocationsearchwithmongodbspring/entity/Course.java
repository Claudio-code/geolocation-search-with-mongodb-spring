package com.search.geolocationsearchwithmongodbspring.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "courses")
public class Course {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private String name;

    public String name() {
        return name;
    }
}
