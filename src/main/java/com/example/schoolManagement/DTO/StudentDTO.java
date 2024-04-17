package com.example.schoolManagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Long parentId;
    private String parentFirstName;
    private String parentLastName;
    private Long teacherId;
    private String classroom;
    private String teacherName;

}
