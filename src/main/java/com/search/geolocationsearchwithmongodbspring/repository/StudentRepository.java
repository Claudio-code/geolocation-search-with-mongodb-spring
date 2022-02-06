package com.search.geolocationsearchwithmongodbspring.repository;

import com.search.geolocationsearchwithmongodbspring.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
