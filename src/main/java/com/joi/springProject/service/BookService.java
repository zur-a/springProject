package com.joi.springProject.service;

import com.joi.springProject.controller.Book;
import com.joi.springProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = repository.findBookByIsbn(book.getIsbn());
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("E-mail already in use");
        }
        repository.save(book);
    }

    public void deleteBook(String isbn) {
        Optional<Book> bookByIsbn = repository.findBookByIsbn(isbn);
        if (!bookByIsbn.isPresent()) {
            throw new NoSuchElementException("Book not found");
        }
        repository.deleteById(bookByIsbn.get().getId());
    }

    public void updateBook(String isbn, Book updatedBook) {
        Optional<Book> bookToBeUpdated = repository.findBookByIsbn(isbn);

        if (!bookToBeUpdated.isPresent()) {
            throw new NoSuchElementException("Book not found");
        }

        // Book exists, perform the update
        Book existingBook = bookToBeUpdated.get();
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setPublisher(updatedBook.getPublisher());
        existingBook.setReleaseDate(updatedBook.getReleaseDate());
        repository.save(existingBook);
    }
}
