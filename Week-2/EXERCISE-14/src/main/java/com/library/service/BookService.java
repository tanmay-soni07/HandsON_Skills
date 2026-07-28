package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    // Default constructor (required for setter injection)
    public BookService() {
    }

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected via setter");
    }

    // Getter method
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void addNewBook(String bookName) {
        if (bookRepository != null) {
            bookRepository.addBook(bookName);
            System.out.println("Book added: " + bookName);
        } else {
            System.out.println("ERROR: BookRepository is not injected!");
        }
    }

    public List<String> listAllBooks() {
        if (bookRepository != null) {
            return bookRepository.getAllBooks();
        } else {
            System.out.println("ERROR: BookRepository is not injected!");
            return new ArrayList<>();
        }
    }

    public void deleteBook(String bookName) {
        if (bookRepository != null) {
            bookRepository.removeBook(bookName);
            System.out.println("Book deleted: " + bookName);
        } else {
            System.out.println("ERROR: BookRepository is not injected!");
        }
    }

    // Import ArrayList
    private static class ArrayList extends java.util.ArrayList {
    }
}