package com.example.student_management_system.service;


import com.example.student_management_system.model.StudentModel;
import com.example.student_management_system.repository.studentRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    private studentRepository repository ;

    public StudentService(studentRepository repository) {
        this.repository = repository;
    }

    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
}
