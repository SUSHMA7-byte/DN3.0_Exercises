package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    @io.swagger.v3.oas.annotations.Operation(
        summary = "Get all books",
        description = "Fetches all books from the bookstore"
    )
    public List<Book> getAllBooks() {
        return List.of(new Book(1L, "1984", "George Orwell")); 
    }

    @GetMapping("/{id}")
    @io.swagger.v3.oas.annotations.Operation(
        summary = "Get a book by ID",
        description = "Fetches a book by its ID"
    )
    public Book getBookById(
        @io.swagger.v3.oas.annotations.Parameter(
            description = "ID of the book to retrieve"
        )
        @PathVariable Long id) {
        
        return new Book(id, "1984", "George Orwell");     }

    @PostMapping
    @io.swagger.v3.oas.annotations.Operation(
        summary = "Add a new book",
        description = "Adds a new book to the bookstore"
    )
    public Book addBook(
        @io.swagger.v3.oas.annotations.Parameter(
            description = "Book to add"
        )
        @RequestBody Book book) {
        return book; 
    }
}
