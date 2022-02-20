package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.entity.Skill;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ValidateService(StudentRepository studentRepository) {
    public Boolean verifyIfStudentExist(Student student) {
        final Example<Student> studentExample = Example.of(student);
        return studentRepository.exists(studentExample);
    }

    public Boolean verifyIfSkillExist(Student student, Skill skillToSave) {
        final List<Skill> skillListFiltered = student.listOfSkills()
                .parallelStream()
                .filter(skill -> verifySkillNameIsEqually(skill, skillToSave))
                .toList();
        return !skillListFiltered.isEmpty();
    }

    private Boolean verifySkillNameIsEqually(Skill skillSaved, Skill skillToSave) {
        return skillSaved.name().equalsIgnoreCase(skillToSave.name());
    }
}
