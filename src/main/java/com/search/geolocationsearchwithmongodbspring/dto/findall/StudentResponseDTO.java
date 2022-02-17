package com.search.geolocationsearchwithmongodbspring.dto.findall;

import com.search.geolocationsearchwithmongodbspring.dto.CourseDTO;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class StudentResponseDTO {
    private String id;
    private String name;
    private LocalDate birthday;
    private CourseDTO course;
    private List<SkillResponseDTO> skills;
    private List<NoteResponseDTO> notes;
}
