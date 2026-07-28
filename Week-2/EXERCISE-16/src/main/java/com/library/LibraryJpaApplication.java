package com.library;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class LibraryJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryJpaApplication.class, args);

        BookService bookService = context.getBean(BookService.class);

        System.out.println("\n===== Spring Data JPA with Hibernate Demo =====");
        System.out.println();

        // Add books
        System.out.println("1. Adding Books...");
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "ISBN-001", 1925, 5);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN-002", 1960, 3);
        Book book3 = new Book("1984", "George Orwell", "ISBN-003", 1949, 2);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "ISBN-004", 1813, 4);

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        System.out.println("Books added successfully!\n");

        // Get all books
        System.out.println("2. All Books in Library:");
        List<Book> allBooks = bookService.getAllBooks();
        allBooks.forEach(System.out::println);
        System.out.println();

        // Find by title
        System.out.println("3. Finding book by title 'The Great Gatsby':");
        Optional<Book> book = bookService.findByTitle("The Great Gatsby");
        book.ifPresent(System.out::println);
        System.out.println();

        // Find by author
        System.out.println("4. Books by George Orwell:");
        List<Book> orwellBooks = bookService.findByAuthor("George Orwell");
        orwellBooks.forEach(System.out::println);
        System.out.println();

        // Find available books
        System.out.println("5. Available Books (copies > 0):");
        List<Book> availableBooks = bookService.findAvailableBooks();
        availableBooks.forEach(System.out::println);
        System.out.println();

        // Find by publication year
        System.out.println("6. Books published in 1960:");
        List<Book> booksFrom1960 = bookService.findByPublicationYear(1960);
        booksFrom1960.forEach(System.out::println);
        System.out.println();

        // Search by title pattern
        System.out.println("7. Books with 'Great' in title:");
        List<Book> searchResults = bookService.searchByTitlePattern("Great");
        searchResults.forEach(System.out::println);
        System.out.println();

        // Find by author and year
        System.out.println("8. Books by Jane Austen published in 1813:");
        List<Book> austenBooks = bookService.findByAuthorAndYear("Jane Austen", 1813);
        austenBooks.forEach(System.out::println);
        System.out.println();

        System.out.println("Spring Data JPA with Hibernate Demo Completed!");
    }
}
