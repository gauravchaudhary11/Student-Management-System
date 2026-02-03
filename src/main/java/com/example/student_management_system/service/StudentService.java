package com.example.student_management_system.service;



import com.example.student_management_system.DTO.StudentRequestDto;
import com.example.student_management_system.DTO.StudentResponseDto;
import com.example.student_management_system.model.StudentModel;
import com.example.student_management_system.repository.studentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private studentRepository repository;

    public StudentService(studentRepository repository) {
        this.repository = repository;
    }


    public StudentResponseDto addStudent(StudentRequestDto dto) {
        StudentModel student=new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved=repository.save(student);
        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );

    }
    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id : " + id)
                );

        // update fields
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel updated = repository.save(student);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }



    public List<StudentResponseDto> getStudent() {
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                ))
                .toList();
    }
    public StudentResponseDto deleteStudent(String id) {

        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id : " + id)
                );

        repository.deleteById(id);

        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }

}