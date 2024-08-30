package com.onlinebookstore.controller;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<EntityModel<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> EntityModel.of(book,
                        linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
                        linkTo(methodOn(BookController.class).getAllBooks()).withRel("books")))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        
        return EntityModel.of(book,
                linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel(),
                linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
    }

    @PostMapping
    public ResponseEntity<EntityModel<Book>> createBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        EntityModel<Book> resource = EntityModel.of(savedBook,
                linkTo(methodOn(BookController.class).getBookById(savedBook.getId())).withSelfRel());
        
        return ResponseEntity.created(resource.getRequiredLink(WebMvcLinkBuilder.IanaLinkRelations.SELF).toUri())
                .body(resource);
    }

    // Other CRUD methods can be implemented similarly
}
