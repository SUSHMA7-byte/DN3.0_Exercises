package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the context
        BookService bookService = context.getBean(BookService.class);

        // Use bookService to perform some actions
        // e.g., bookService.addBook(new Book("Spring in Action", "Craig Walls"));

        System.out.println("Library Management Application is running successfully.");
    }
}
