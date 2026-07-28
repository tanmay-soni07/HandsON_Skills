import java.util.Scanner;

public class Main {

    static Task head = null;
    static Scanner sc = new Scanner(System.in);

    // Add Task
    public static void addTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Status: ");
        String status = sc.nextLine();

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task Added Successfully.\n");
    }

    // Search Task
    public static void searchTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {

                System.out.println("\nTask Found");
                System.out.println(temp);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.\n");
    }

    // Display Tasks
    public static void displayTasks() {

        if (head == null) {
            System.out.println("No Tasks Available.\n");
            return;
        }

        Task temp = head;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Delete Task
    public static void deleteTask() {

        System.out.print("Enter Task ID to Delete: ");
        int id = sc.nextInt();

        if (head == null) {
            System.out.println("Task List is Empty.\n");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully.\n");
            return;
        }

        Task prev = head;
        Task curr = head.next;

        while (curr != null) {

            if (curr.taskId == id) {

                prev.next = curr.next;

                System.out.println("Task Deleted Successfully.\n");
                return;
            }

            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task Not Found.\n");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("===== Task Management System =====");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    searchTask();
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    deleteTask();
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