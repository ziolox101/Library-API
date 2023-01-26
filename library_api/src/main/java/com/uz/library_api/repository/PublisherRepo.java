package com.uz.library_api.repository;

import com.uz.library_api.model.Publisher.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    Publisher findPublisherByName(String name);
    boolean existsByName(String name);
    boolean existsById(long id);
}
