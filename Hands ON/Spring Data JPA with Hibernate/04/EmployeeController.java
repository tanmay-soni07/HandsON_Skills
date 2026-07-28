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
    EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee){

        employee.setId(id);

        return repository.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){

        repository.deleteById(id);

        return "Employee Deleted Successfully";

    }

}