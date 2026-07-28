package com.library.service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Delete book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Find book by title
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Find books by author
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    // Find book by ISBN
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    // Find books by publication year
    public List<Book> findByPublicationYear(Integer year) {
        return bookRepository.findByPublicationYear(year);
    }

    // Find available books
    public List<Book> findAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }

    // Find books by title pattern
    public List<Book> searchByTitlePattern(String pattern) {
        return bookRepository.findByTitlePattern(pattern);
    }

    // Find books by author and year
    public List<Book> findByAuthorAndYear(String author, Integer year) {
        return bookRepository.findByAuthorAndYear(author, year);
    }
}
