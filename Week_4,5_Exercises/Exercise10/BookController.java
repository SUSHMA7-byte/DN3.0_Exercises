package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = List.of(
            new BookDTO(1L, "Book 1", "Author 1", 29.99),
            new BookDTO(2L, "Book 2", "Author 2", 39.99)
        );
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO book = new BookDTO(id, "Book " + id, "Author " + id, 29.99 + id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
