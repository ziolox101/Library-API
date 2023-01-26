package com.uz.library_api.service.BookLend;

import com.uz.library_api.exceptions.Book.BookNotFound;
import com.uz.library_api.exceptions.BookLend.LendedBookNotFound;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.BookLend.BookLend;
import com.uz.library_api.model.BookLend.DTO.BookLendDTO;
import com.uz.library_api.model.BookLend.DTO.BookLendMapper;
import com.uz.library_api.repository.BookLendRepo;
import com.uz.library_api.repository.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookLendAdminService{
    private BookLendRepo bookLendRepo;
    private BookRepo bookRepo;

    public List<BookLendDTO> getALl(){
        return BookLendMapper.mapEntityListToDto(bookLendRepo.findAll());
    }

    public BookLendDTO getSingle(long id){
        return BookLendMapper.mapEntityToDto(getById(id));
    }

    public void deleteBookLendedById(long id) {
        BookLend bookLended = getById(id);
        Book book = bookRepo.findById(bookLended.getBook().getId()).orElseThrow(() -> new BookNotFound("Book was not found"));
        book.setAmount(book.getAmount() + 1);
        bookRepo.save(book);
        bookLendRepo.deleteById(id);
    }
    private BookLend getById(long id){
        return bookLendRepo.findById(id).orElseThrow(() -> new LendedBookNotFound("Lended Book was not found"));
    }

}
