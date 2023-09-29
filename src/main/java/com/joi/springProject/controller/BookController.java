package com.joi.springProject.controller;

import com.joi.springProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @PostMapping("/addBook")
    public void registerNewBook(@RequestBody Book book) {
        service.addNewBook(book);
    }
}
