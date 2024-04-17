package com.example.schoolManagement.repository;

import com.example.schoolManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
