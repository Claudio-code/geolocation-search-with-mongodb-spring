package com.search.geolocationsearchwithmongodbspring.dto.note;

import com.search.geolocationsearchwithmongodbspring.entity.Student;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NoteRequestDTO {
    private Student student;
    private Double noteValue;
}
