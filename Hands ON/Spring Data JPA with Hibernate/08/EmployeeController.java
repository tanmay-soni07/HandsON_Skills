package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/jpql/{name}")
    public List<Employee> searchByName(@PathVariable String name) {

        return repository.getEmployeeByName(name);

    }

    @GetMapping("/native/{email}")
    public List<Employee> searchByEmail(@PathVariable String email) {

        return repository.getEmployeeByEmail(email);

    }

}