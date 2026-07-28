package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL Query
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> getEmployeeByName(@Param("name") String name);

    // Native SQL Query
    @Query(value = "SELECT * FROM employees WHERE email = ?1",
            nativeQuery = true)
    List<Employee> getEmployeeByEmail(String email);

}