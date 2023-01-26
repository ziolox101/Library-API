package com.uz.library_api.exceptions.BookLend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Book is not in stock")
public class BookIsNotInStock extends RuntimeException{
    public BookIsNotInStock(String message) {
        super(message);
    }
}
