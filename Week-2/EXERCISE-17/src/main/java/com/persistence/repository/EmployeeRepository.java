package com.persistence.repository;

import com.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Spring Data JPA automatically generates queries for these methods
    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(Double salary);

    List<Employee> findBySalaryLessThan(Double salary);

    // Custom JPQL query
    @Query("SELECT e FROM Employee e WHERE e.department = :department ORDER BY e.salary DESC")
    List<Employee> findEmployeesByDepartmentOrderBySalary(@Param("department") String department);

    // Custom JPQL query for average salary
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department = :department")
    Double getAverageSalaryByDepartment(@Param("department") String department);

    // Custom JPQL query to find high earners
    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)")
    List<Employee> findHighEarners();
}
