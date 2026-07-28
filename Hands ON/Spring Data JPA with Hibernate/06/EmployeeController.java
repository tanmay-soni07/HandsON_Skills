package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import org.springframework.web.bind.annotation.*;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/page")
    public Page<Employee> getEmployeesPage(
            @RequestParam int page,
            @RequestParam int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);

    }

    @GetMapping("/sort")
    public List<Employee> getEmployeesSorted() {

        return repository.findAll(
                Sort.by(Sort.Direction.ASC, "name"));

    }

}