package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

        System.out.println("Constructor Injection Successful");

    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

        System.out.println("Setter Injection Successful");

    }

    public void display() {

        System.out.println("Book Service Working");

        bookRepository.display();

    }

}