package com.joi.springProject.repository;

import com.joi.springProject.controller.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //@Query("SELECT s FROM Book s WHERE s.isbn = ?1")
    Optional<Book> findBookByIsbn(String isbn);
}
