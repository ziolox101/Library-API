package com.uz.library_api.controller.Book;

import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.Book.DTO.BookDto;
import com.uz.library_api.service.Book.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class BookController {
    BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<List<BookDto>> getAll(){
        log.info("Selected user all books");
        return new ResponseEntity<>(bookService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/book/library")
    public ResponseEntity<List<BookDto>> getByLibraryName(@RequestParam String library){
        log.info("User selected books in library " + library);
        return new ResponseEntity<>(bookService.getByLibraryName(library), HttpStatus.OK);
    }

    @GetMapping("/book/publisher")
    public ResponseEntity<List<BookDto>> getByPublisherName(@RequestParam String publisher){
        log.info("User selected books by publisher " + publisher);
        return new ResponseEntity<>(bookService.getByPublisher(publisher), HttpStatus.OK);
    }

    @GetMapping("/book/author")
    public ResponseEntity<List<BookDto>> getByAuthor(@RequestParam String name, @RequestParam String surname){
        log.info("User selected books by author " + name + surname);
        return new ResponseEntity<>(bookService.getByAuthor(name, surname), HttpStatus.OK);
    }
}
