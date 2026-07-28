package com.persistence.service;

import com.persistence.entity.Employee;
import com.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CRUD Operations (automatically provided by Spring Data JPA)

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Custom Queries

    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> findHighEarners() {
        return employeeRepository.findHighEarners();
    }

    public Double getAverageSalaryByDepartment(String department) {
        return employeeRepository.getAverageSalaryByDepartment(department);
    }

    public List<Employee> findEmployeesByDepartmentOrderBySalary(String department) {
        return employeeRepository.findEmployeesByDepartmentOrderBySalary(department);
    }
}
