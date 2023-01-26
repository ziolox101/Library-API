package com.uz.library_api.repository;

import com.uz.library_api.model.BookLend.BookLend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLendRepo extends JpaRepository<BookLend, Long> {

    List<BookLend> getBookLendByUser_Login(String username);
    void deleteBookLendByBook_IdAndUser_Id(long bookId, long userId);

}
