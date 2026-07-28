package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query Method
    List<Employee> findByName(String name);

    // JPQL Query
    @Query("SELECT e FROM Employee e WHERE e.email=:email")
    List<Employee> getEmployeeByEmail(@Param("email") String email);

    // Named Query
    List<Employee> findByEmployeeEmail(String email);

}