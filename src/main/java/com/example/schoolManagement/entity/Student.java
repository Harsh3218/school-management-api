package com.example.schoolManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor

public class Student {
    @Setter
    @Getter
    @Id
    @GeneratedValue

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String fatherName;
    private String motherName;

}
