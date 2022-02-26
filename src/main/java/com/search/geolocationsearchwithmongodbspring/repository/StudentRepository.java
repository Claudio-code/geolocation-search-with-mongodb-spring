package com.search.geolocationsearchwithmongodbspring.repository;

import com.search.geolocationsearchwithmongodbspring.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {
    @Query(value = "{ name: /?0/i }")
    List<Student> findAllBy(String name);
}
