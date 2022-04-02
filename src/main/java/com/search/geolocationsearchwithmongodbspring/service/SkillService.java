package com.search.geolocationsearchwithmongodbspring.service;

import com.search.geolocationsearchwithmongodbspring.dto.skill.SkillRequestDTO;
import com.search.geolocationsearchwithmongodbspring.entity.Skill;
import com.search.geolocationsearchwithmongodbspring.entity.Student;
import com.search.geolocationsearchwithmongodbspring.exception.SkillAlreadyExistsException;
import com.search.geolocationsearchwithmongodbspring.factory.SkillFactory;
import com.search.geolocationsearchwithmongodbspring.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public record SkillService(StudentService studentService, StudentRepository studentRepository, ValidateService validateService) {
    public void create(SkillRequestDTO skillRequestDTO) {
        final Student student = studentService.findOne(skillRequestDTO.getStudent());
        final SkillFactory skillFactory = SkillFactory
                .builder()
                .skillRequestDTO(skillRequestDTO)
                .build();
        final Skill skillToSave = skillFactory.make();
        if (validateService.verifyIfSkillExist(student, skillToSave)) {
            throw new SkillAlreadyExistsException();
        }
        student.addNewSkill(skillToSave);
        studentRepository.save(student);
    }
}
