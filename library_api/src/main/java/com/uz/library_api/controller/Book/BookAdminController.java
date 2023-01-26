package com.uz.library_api.controller.Book;

import com.uz.library_api.model.Book.DTO.BookDto;
import com.uz.library_api.model.Book.DTO.BookEditDto;
import com.uz.library_api.model.Book.DTO.BookRequestDto;
import com.uz.library_api.service.Book.BookService;
import com.uz.library_api.service.Book.BookServiceAdmin;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
@Slf4j
public class BookAdminController {
    private BookServiceAdmin bookService;


    @PostMapping("/book")
    public ResponseEntity<BookDto> addBook(@RequestBody BookRequestDto dto){
        log.info("Admin adding book " + dto.getTitle());
        return new ResponseEntity<>(bookService.addBook(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/book")
    public ResponseEntity<BookDto> editBook(@RequestBody BookEditDto dto){
        log.info("Admin editing book " + dto.getId());
        return new ResponseEntity<>(bookService.editBook(dto),HttpStatus.OK);
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        log.info("Admin deleting book " + id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
