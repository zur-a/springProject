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
    public ResponseEntity<String> deleteBook(@PathVariable(value="isbn")String isbn) {
        try {
            service.deleteBook(isbn);
            //Returning the feedback if the book is deleted
            return new ResponseEntity<>("The book has been deleted", HttpStatus.CREATED);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
      }

    @PutMapping("/updateBook/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable(value="isbn")String isbn, @RequestBody Book updatedBook) {
        Optional<Book> bookToBeUpdated = repository.findBookByIsbn(isbn);
        if (bookToBeUpdated.isPresent()) {
            bookToBeUpdated.get().setAuthor(updatedBook.getAuthor());
            bookToBeUpdated.get().setTitle(updatedBook.getTitle());
            bookToBeUpdated.get().setPublisher(updatedBook.getPublisher());
            bookToBeUpdated.get().setReleaseDate(updatedBook.getReleaseDate());
            repository.save(bookToBeUpdated.get());
        }
        return new ResponseEntity<Book>(bookToBeUpdated.get(), HttpStatus.OK);
    }
}
