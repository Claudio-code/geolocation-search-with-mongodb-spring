package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.note.NoteRequestDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Note;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public record NoteService(StudentService studentService, StudentRepository studentRepository, ValidateService validateService) {
    public void create(NoteRequestDTO noteRequestDTO) {
        final Student student = studentService.findOne(noteRequestDTO.getStudent());
        final Note noteToSave = Note.builder()
                .value(noteRequestDTO.getNoteValue())
                .build();
        student.addNewNote(noteToSave);
        studentRepository.save(student);
    }
}
