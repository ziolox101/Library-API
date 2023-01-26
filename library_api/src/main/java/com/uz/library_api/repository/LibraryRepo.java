package com.uz.library_api.repository;

import com.uz.library_api.model.Library.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {
    Library findByName(String name);
}
