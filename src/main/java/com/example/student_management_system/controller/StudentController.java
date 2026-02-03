package com.example.student_management_system.controller;

import com.example.student_management_system.DTO.StudentRequestDto;
import com.example.student_management_system.DTO.StudentResponseDto;
import com.example.student_management_system.model.StudentModel;
import com.example.student_management_system.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller->service->dto->repository->model


@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    // create Function API
    @GetMapping("/Student")
    public List<StudentResponseDto> getStudent(){
        return service.getStudent();

    }
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){

        return service.addStudent(student);
    }
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id, @RequestBody StudentRequestDto student ){
       return service.updateStudent(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public StudentResponseDto deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }
}

