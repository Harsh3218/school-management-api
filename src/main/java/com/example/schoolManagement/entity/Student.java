package com.example.schoolManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/*
* This Class Represents Student Entity that maps the data to the database
*/

//Lombok's annotations for generating Getters, Setters, Constructor with parameters and non-arguments constructor
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Fields of the table
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String fatherName;
    private String motherName;

}
