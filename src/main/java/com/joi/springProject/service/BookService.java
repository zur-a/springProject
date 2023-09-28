package com.joi.springProject.service;

import com.joi.springProject.controller.Book;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BookService {
    public List<Book> getBooks() {
        return List.of(
                new Book(
                        1L,
                        "A divina Comédia",
                        "Dante Alighieri",
                        "978-85-7326-121-9",
                        "Editora 34",
                        LocalDate.of(2020, Month.NOVEMBER, 4))
        );
    }
}
