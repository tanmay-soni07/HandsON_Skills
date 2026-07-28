import java.util.Scanner;

public class Main {

    static Employee[] employees = new Employee[100];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    // Add Employee
    public static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Position: ");
        String position = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees[count++] = new Employee(id, name, position, salary);

        System.out.println("Employee Added Successfully.\n");
    }

    // Search Employee
    public static void searchEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                System.out.println("\nEmployee Found");
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("Employee Not Found.\n");
    }

    // Display Employees
    public static void displayEmployees() {

        if (count == 0) {
            System.out.println("No Employee Records.\n");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public static void deleteEmployee() {

        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[count - 1] = null;
                count--;

                System.out.println("Employee Deleted Successfully.\n");
                return;
            }
        }

        System.out.println("Employee Not Found.\n");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    searchEmployee();
                    break;

                case 3:
                    displayEmployees();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.\n");
            }
        }
    }
}