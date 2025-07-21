package com.example.StudentApp.Repository;

import com.example.StudentApp.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
