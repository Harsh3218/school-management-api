package com.example.schoolManagement.controller;

import com.example.schoolManagement.entity.Parent;
import com.example.schoolManagement.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping("/add")
    public Parent saveParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @GetMapping("/{id}")
    public Parent getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @GetMapping("/all")
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @PutMapping("/{id}")
    public Parent updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        return parentService.updateParent(id, parent);
    }

    @DeleteMapping("/{id}")
    public String deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return "Deleted parent";
    }
}
