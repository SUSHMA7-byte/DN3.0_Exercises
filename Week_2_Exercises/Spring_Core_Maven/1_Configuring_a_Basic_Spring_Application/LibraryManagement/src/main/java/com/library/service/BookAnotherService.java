package com.library.service;

import com.library.repository.BookRepository;

public class BookAnotherService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Example method that uses the BookRepository
    public void performService() {
        // Logic using bookRepository
        bookRepository.someRepositoryMethod();
    }
}
