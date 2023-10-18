package com.spring.boot.apptesting.controllers;

import com.spring.boot.apptesting.model.Book;
import com.spring.boot.apptesting.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book findOne(@PathVariable int id) {
        return bookService.findOne(id);
    }
}
