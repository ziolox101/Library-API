package com.uz.library_api.exceptions.Book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Book was not found")
public class BookNotFound extends RuntimeException{
    public BookNotFound(String message) {
        super(message);
    }
}
