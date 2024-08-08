package com.example.library;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Additional methods for BookService
    public void performService() {
        // Implementation for service logic
        System.out.println("BookService is performing some service with the repository.");
    }
}
