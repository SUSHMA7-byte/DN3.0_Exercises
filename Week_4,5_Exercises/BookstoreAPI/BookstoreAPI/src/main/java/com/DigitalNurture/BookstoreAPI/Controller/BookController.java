package com.DigitalNurture.BookstoreAPI.Controller;

import com.DigitalNurture.BookstoreAPI.Model.Book;
import com.DigitalNurture.BookstoreAPI.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET /books - Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET /books/{id} - Retrieve a book by its ID
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // POST /books - Create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    // PUT /books/{id} - Update an existing book by its ID
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    // DELETE /books/{id} - Delete a book by its ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author
    ) {
        if (title != null && author != null) {
            return bookService.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            return bookService.findByTitle(title);
        } else if (author != null) {
            return bookService.findByAuthor(author);
        } else {
            return bookService.getAllBooks();
        }
    }

}
