package com.uz.library_api.exceptions.Library;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Library")
public class LibraryNotFound extends RuntimeException{
    public LibraryNotFound(String message) {
        super(message);
    }
}
