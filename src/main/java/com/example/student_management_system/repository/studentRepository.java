package com.example.student_management_system.repository;

import com.example.student_management_system.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentRepository extends MongoRepository<StudentModel, String> {

}
