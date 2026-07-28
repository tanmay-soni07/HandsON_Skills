package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.entity.Department;
import com.employee.repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentRepository repository;

    @GetMapping
    public List<Department> getDepartments(){
        return repository.findAll();
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return repository.save(department);
    }

}