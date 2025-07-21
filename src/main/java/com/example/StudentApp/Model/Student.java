package com.example.StudentApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private String department;
}

