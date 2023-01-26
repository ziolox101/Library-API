package com.uz.library_api.exceptions.Genre;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such genre")
public class GenreNotFound extends RuntimeException{
    public GenreNotFound(String message) {
        super(message);
    }
}
