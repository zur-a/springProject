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
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public ResponseEntity<String> deleteBook(@PathVariable(value="isbn") String isbn) {
        try {
            service.deleteBook(isbn);
            // Return 204 status (No Content) as the book has been successfully deleted
            return new ResponseEntity<>("The book has been deleted", HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            // Book not found, return 404 status
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other exceptions as needed
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateBook/{isbn}")
    public ResponseEntity<String> updateBook(@PathVariable(value="isbn")String isbn, @RequestBody Book updatedBook) {
        try {
            service.updateBook(isbn, updatedBook);
            //Returning the feedback if the book is updated
            return new ResponseEntity<>("The book with isbn: " + isbn + " has been updated", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // Book not found, return 404 status
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other exceptions as needed
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
