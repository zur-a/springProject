package com.joi.springProject.controller;

import com.joi.springProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping()
    public List<Book> getBooks() {
        return service.getBooks();
    }
}
