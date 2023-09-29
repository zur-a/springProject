package com.joi.springProject.controller;

import com.joi.springProject.repository.BookRepository;
import com.joi.springProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    BookRepository repository;

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @PostMapping("/addBook")
    public void registerNewBook(@RequestBody Book book) {
        service.addNewBook(book);
    }

    @DeleteMapping("/deleteBook/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable(value="isbn")String isbn) {
        try {
            service.deleteBook(isbn);
            //Returning the feedback if the book is deleted
            return new ResponseEntity<>("The book has been deleted", HttpStatus.CREATED);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
      }
}
