package com.joi.springProject.configuration;

import com.joi.springProject.controller.Book;
import com.joi.springProject.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JUNE;
import static java.time.Month.NOVEMBER;

@Configuration
public class BookConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            Book comedia = new Book(
                    "A divina Comédia",
                    "Dante Alighieri",
                    "978-85-7326-121-9",
                    "Editora 34",
                    LocalDate.of(2020, NOVEMBER, 4)
            );

            Book faustoi = new Book(
                    "Fausto I",
                    "Johann Wolfgang Von Goethe",
                    "978-85-7326-479-1",
                    "Editora 34",
                    LocalDate.of(2020, JUNE, 12)
            );

            Book faustoii = new Book(
                    "Fausto II",
                    "Johann Wolfgang Von Goethe",
                    "978-85-7326-480-7",
                    "Editora 34",
                    LocalDate.of(2020, JUNE, 12)
            );

            repository.saveAll(
                    List.of(comedia, faustoi, faustoii)
            );
        };
    }
}
