package com.joi.springProject.service;

import com.joi.springProject.controller.Book;
import com.joi.springProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public void addNewBook(Book book) {
        System.out.println(book);
    }
}
