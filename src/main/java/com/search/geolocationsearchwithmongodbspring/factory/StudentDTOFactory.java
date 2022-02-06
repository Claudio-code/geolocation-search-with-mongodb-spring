package com.search.geolocationsearchwithmongodbspring.factory;

import com.search.geolocationsearchwithmongodbspring.dto.StudentDTO;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
public class StudentDTOFactory implements FactoryInterface<StudentDTO> {
    private String name;
    private String birthday;
    private String courseName;

    @Override
    public StudentDTO make() {
        CourseDTOFactory courseDTOFactory = new CourseDTOFactory(courseName);
        LocalDate birthdayDate = LocalDate.parse(birthday);
        return StudentDTO.builder()
            .name(name)
            .birthday(birthdayDate)
            .course(courseDTOFactory.make())
            .build();
    }
}
