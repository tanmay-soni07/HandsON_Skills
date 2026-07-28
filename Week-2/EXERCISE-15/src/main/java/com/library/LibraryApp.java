package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {

    public static void main(String[] args) {
        System.out.println("===== Library Management Application (Maven Project) =====");
        System.out.println();
        System.out.println("Maven Project with Spring Dependencies Configured:");
        System.out.println("- Spring Context");
        System.out.println("- Spring AOP");
        System.out.println("- Spring WebMVC");
        System.out.println();

        // Load the Spring application context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from the Spring context
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("Spring Application Context Loaded Successfully!");
        System.out.println();

        // Display all books
        System.out.println("Available Books:");
        for (String book : bookService.listAllBooks()) {
            System.out.println("- " + book);
        }
        System.out.println();

        // Add a new book
        bookService.addNewBook("The Hobbit");
        System.out.println();

        // Display updated list of books
        System.out.println("Updated Books List:");
        for (String book : bookService.listAllBooks()) {
            System.out.println("- " + book);
        }

        System.out.println();
        System.out.println("Maven Project Test Completed Successfully!");
    }
}