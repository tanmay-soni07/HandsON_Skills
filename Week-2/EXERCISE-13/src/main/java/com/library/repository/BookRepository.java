package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<String> books = new ArrayList<>();

    public BookRepository() {
        // Initialize with some sample books
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984");
    }

    public void addBook(String bookName) {
        books.add(bookName);
    }

    public List<String> getAllBooks() {
        return books;
    }

    public void removeBook(String bookName) {
        books.remove(bookName);
    }
}