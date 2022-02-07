package com.search.geolocationsearchwithmongodbspring.repository;

import com.search.geolocationsearchwithmongodbspring.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
