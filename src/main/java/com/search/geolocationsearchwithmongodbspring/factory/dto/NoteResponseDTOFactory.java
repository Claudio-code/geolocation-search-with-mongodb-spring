package com.search.geolocationsearchwithmongodbspring.factory.dto;

import com.search.geolocationsearchwithmongodbspring.dto.findall.NoteResponseDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Note;
import com.search.geolocationsearchwithmongodbspring.factory.FactoryInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoteResponseDTOFactory implements FactoryInterface<NoteResponseDTO> {
    private Note note;

    @Override
    public NoteResponseDTO make() {
        return NoteResponseDTO.builder()
                .value(note.noteValue())
                .build();
    }
}
