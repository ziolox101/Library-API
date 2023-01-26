package com.uz.library_api.repository;

import com.uz.library_api.model.Location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
    boolean existsByNumberOfRackAndNumberOfShelf(long rack, long shelf);
    Location getByNumberOfRackAndNumberOfShelf(long rack, long shelf);
    boolean existsById(long id);
}
