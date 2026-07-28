package com.persistence;

import com.persistence.entity.Employee;
import com.persistence.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PersistenceComparisonApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PersistenceComparisonApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        System.out.println("\n===== JPA vs Hibernate vs Spring Data JPA Demo =====");
        System.out.println();

        // 1. Adding Employees (CREATE)
        System.out.println("1. Adding Employees...");
        Employee emp1 = new Employee("John Doe", "john@company.com", "IT", 75000.0);
        Employee emp2 = new Employee("Jane Smith", "jane@company.com", "HR", 65000.0);
        Employee emp3 = new Employee("Bob Johnson", "bob@company.com", "IT", 85000.0);
        Employee emp4 = new Employee("Alice Brown", "alice@company.com", "Finance", 72000.0);
        Employee emp5 = new Employee("Charlie Wilson", "charlie@company.com", "IT", 95000.0);

        employeeService.addEmployee(emp1);
        employeeService.addEmployee(emp2);
        employeeService.addEmployee(emp3);
        employeeService.addEmployee(emp4);
        employeeService.addEmployee(emp5);
        System.out.println("Employees added successfully!\n");

        // 2. Retrieving All Employees (READ)
        System.out.println("2. All Employees in System:");
        List<Employee> allEmployees = employeeService.getAllEmployees();
        allEmployees.forEach(System.out::println);
        System.out.println();

        // 3. Find by Email
        System.out.println("3. Finding employee by email 'john@company.com':");
        Optional<Employee> employee = employeeService.findByEmail("john@company.com");
        employee.ifPresent(System.out::println);
        System.out.println();

        // 4. Find by Department
        System.out.println("4. Employees in IT Department:");
        List<Employee> itEmployees = employeeService.findByDepartment("IT");
        itEmployees.forEach(System.out::println);
        System.out.println();

        // 5. Find High Earners
        System.out.println("5. High Earners (above average salary):");
        List<Employee> highEarners = employeeService.findHighEarners();
        highEarners.forEach(System.out::println);
        System.out.println();

        // 6. Average Salary by Department
        System.out.println("6. Average Salary by Department:");
        Double itAvg = employeeService.getAverageSalaryByDepartment("IT");
        Double hrAvg = employeeService.getAverageSalaryByDepartment("HR");
        Double financeAvg = employeeService.getAverageSalaryByDepartment("Finance");
        System.out.println("IT Average: $" + itAvg);
        System.out.println("HR Average: $" + hrAvg);
        System.out.println("Finance Average: $" + financeAvg);
        System.out.println();

        // 7. Employees by Department Ordered by Salary
        System.out.println("7. IT Employees Ordered by Salary (DESC):");
        List<Employee> sortedEmployees = employeeService.findEmployeesByDepartmentOrderBySalary("IT");
        sortedEmployees.forEach(System.out::println);
        System.out.println();

        // 8. Update Employee (UPDATE)
        System.out.println("8. Updating employee salary...");
        Optional<Employee> empToUpdate = employeeService.getEmployeeById(1L);
        if (empToUpdate.isPresent()) {
            Employee updatedEmp = empToUpdate.get();
            updatedEmp.setSalary(80000.0);
            employeeService.updateEmployee(updatedEmp);
            System.out.println("Updated: " + updatedEmp);
        }
        System.out.println();

        // 9. Delete Employee (DELETE)
        System.out.println("9. Deleting employee with ID 2...");
        employeeService.deleteEmployee(2L);
        System.out.println("Employee deleted!");
        System.out.println();

        // 10. Final Count
        System.out.println("10. Final Employee Count: " + employeeService.getAllEmployees().size());
        System.out.println();

        System.out.println("===== Key Takeaways =====");
        System.out.println("1. JPA = Specification (Contract)");
        System.out.println("2. Hibernate = ORM Implementation");
        System.out.println("3. Spring Data JPA = Abstraction Layer");
        System.out.println("4. Spring Data JPA reduces boilerplate code significantly!");
        System.out.println("5. With Spring Data JPA, no need to write CRUD methods!");
        System.out.println();
    }
}
