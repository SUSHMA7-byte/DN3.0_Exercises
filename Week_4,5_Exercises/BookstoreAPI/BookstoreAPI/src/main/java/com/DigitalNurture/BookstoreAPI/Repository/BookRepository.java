package com.DigitalNurture.BookstoreAPI.Repository;

import com.DigitalNurture.BookstoreAPI.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleAndAuthor(String title, String author);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);
}

}
