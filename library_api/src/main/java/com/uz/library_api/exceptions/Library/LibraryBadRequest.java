package com.uz.library_api.exceptions.Library;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad request to save library")
public class LibraryBadRequest extends RuntimeException{
    public LibraryBadRequest(String message) {
        super(message);
    }
}
