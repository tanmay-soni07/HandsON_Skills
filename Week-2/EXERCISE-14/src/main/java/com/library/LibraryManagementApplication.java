package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("===== Library Management System (Dependency Injection) =====");
        System.out.println();

        // Load the Spring application context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from the Spring context
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println();

        // Display all books
        System.out.println("Available Books:");
        for (String book : bookService.listAllBooks()) {
            System.out.println("- " + book);
        }
        System.out.println();

        // Add a new book
        bookService.addNewBook("Pride and Prejudice");
        System.out.println();

        // Display updated list of books
        System.out.println("Updated Books List:");
        for (String book : bookService.listAllBooks()) {
            System.out.println("- " + book);
        }
        System.out.println();

        // Delete a book
        bookService.deleteBook("1984");
        System.out.println();

        // Display final list of books
        System.out.println("Final Books List:");
        for (String book : bookService.listAllBooks()) {
            System.out.println("- " + book);
        }

        System.out.println();
        System.out.println("Dependency Injection Test Completed Successfully!");
    }
}