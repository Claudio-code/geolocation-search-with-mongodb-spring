package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.entity.Skill;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record ValidateService(StudentRepository studentRepository) {
    public Boolean verifyIfStudentExist(Student student) {
        final Example<Student> studentExample = Example.of(student);
        final Optional<Student> optionalStudent = studentRepository.findOne(studentExample);
        return optionalStudent.isPresent();
    }

    public Boolean verifyIfSkillExist(Student student, Skill skillToSave) {
        final List<Skill> skillList = student.listOfSkills();
        final List<Skill> skillListFiltered = skillList.stream()
                .filter(skill -> skill.name().equalsIgnoreCase(skillToSave.name()))
                .toList();
        return !skillListFiltered.isEmpty();
    }
}
