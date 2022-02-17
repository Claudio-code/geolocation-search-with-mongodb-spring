package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.note.NoteRequestDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class NoteRequestDTOFactory implements FactoryInterface<NoteRequestDTO> {
    private String studentId;
    private Double noteValue;

    @Override
    public NoteRequestDTO make() {
        final Student student = Student.builder()
                .id(studentId)
                .build();
        return NoteRequestDTO.builder()
                .student(student)
                .noteValue(noteValue)
                .build();
    }
}
