package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    // Method to get books
    public List<String> getBooks() {
        return Arrays.asList("Book1", "Book2", "Book3");
    }

    public void someRepositoryMethod() {
        System.out.println("This is the Repository Nethod!");
    }
}
