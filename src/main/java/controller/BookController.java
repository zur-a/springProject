package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class BookController {
    @GetMapping
    public List<Book> list() {
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
