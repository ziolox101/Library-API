package com.uz.library_api.exceptions.Genre;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Genre exists")
public class GenreExists extends RuntimeException{
    public GenreExists(String message) {
        super(message);
    }
}
