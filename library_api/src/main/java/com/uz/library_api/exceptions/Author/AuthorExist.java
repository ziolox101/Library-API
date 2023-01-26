package com.uz.library_api.exceptions.Author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Author already exist")
public class AuthorExist extends RuntimeException{
    public AuthorExist(String message) {
        super(message);
    }
}
