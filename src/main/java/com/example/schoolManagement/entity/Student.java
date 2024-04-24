package com.example.schoolManagement.entity;

import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

}
