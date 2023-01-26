package com.uz.library_api.exceptions.Author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Author")
public class AuthorNotFound extends RuntimeException {
    public AuthorNotFound(String message) {
        super(message);
    }
}