package com.uz.library_api.repository;

import com.uz.library_api.model.Author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

   boolean existsById(long id);
   boolean existsByNameAndSurname(String name, String username);
   Author findByNameAndSurname(String name, String username);
}
