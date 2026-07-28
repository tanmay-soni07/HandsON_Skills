package com.library;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> getBooks() {

        return repository.findAll();

    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {

        return repository.save(book);

    }

}