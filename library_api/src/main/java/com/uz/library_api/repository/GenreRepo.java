package com.uz.library_api.repository;

import com.uz.library_api.model.Genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {
    boolean existsById(long id);
    boolean existsByName(String name);
    Genre findByName(String name);
}
