package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addNewBook(String bookName) {
        bookRepository.addBook(bookName);
        System.out.println("Book added: " + bookName);
    }

    public List<String> listAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void deleteBook(String bookName) {
        bookRepository.removeBook(bookName);
        System.out.println("Book deleted: " + bookName);
    }
}