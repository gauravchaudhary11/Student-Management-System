package com.example.student_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection ="StudentInformation")
public class StudentModel {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;
}
