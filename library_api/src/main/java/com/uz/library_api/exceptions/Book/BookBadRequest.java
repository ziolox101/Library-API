package com.uz.library_api.exceptions.Book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Book bad request")
public class BookBadRequest extends RuntimeException{
    public BookBadRequest(String message) {
        super(message);
    }
}
