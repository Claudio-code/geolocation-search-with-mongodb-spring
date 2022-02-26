package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.findall.NoteResponseDTO;
import com.search.geolocationsearchwithmongodbspring.dto.findall.SkillResponseDTO;
import com.search.geolocationsearchwithmongodbspring.dto.findall.StudentResponseDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.Builder;

import java.util.List;

@Builder
public class StudentResponseDTOFactory implements FactoryInterface<StudentResponseDTO> {
    private Student student;

    @Override
    public StudentResponseDTO make() {
        final CourseDTOFactory courseDTOFactory = new CourseDTOFactory(student.course().name());
        return StudentResponseDTO.builder()
                .id(student.id())
                .name(student.name())
                .birthday(student.birthday())
                .course(courseDTOFactory.make())
                .notes(makeNoteDTOList())
                .skills(makeSkillDTOList())
                .build();
    }

    private List<NoteResponseDTO> makeNoteDTOList() {
        return student.listOfNotes()
                .stream()
                .parallel()
                .map(note -> new NoteResponseDTOFactory(note).make())
                .toList();
    }

    private List<SkillResponseDTO> makeSkillDTOList() {
        return student.listOfSkills()
                .stream()
                .parallel()
                .map(skill -> new SkillResponseDTOFactory(skill).make())
                .toList();
    }
}
