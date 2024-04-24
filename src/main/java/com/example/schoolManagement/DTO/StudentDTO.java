package com.example.schoolManagement.DTO;

import lombok.Getter;
import lombok.Setter;

public class StudentDTO {


    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String firstName;
    @Setter
    @Getter
    private String lastName;
    @Setter
    @Getter
    private Integer age;
    @Setter
    @Getter
    private Long parentId;
    private String parentFirstName;
    private String parentLastName;

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

}
