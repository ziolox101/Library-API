package com.uz.library_api.repository;

import com.uz.library_api.model.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByLibrary_Name(String name);
    List<Book> findByGenre_Name(String genre);
    List<Book> findByPublisher_Name(String publisher);
    List<Book> findByAuthor_NameAndAuthor_Surname(String name, String surname);
    boolean existsById(long id);
}
