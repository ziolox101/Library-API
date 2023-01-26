package com.uz.library_api.exceptions.BookLend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Not Found lended book")
public class LendedBookNotFound extends RuntimeException{
    public LendedBookNotFound(String message) {
        super(message);
    }
}
