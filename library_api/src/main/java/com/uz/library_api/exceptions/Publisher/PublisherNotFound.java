package com.uz.library_api.exceptions.Publisher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such publisher")
public class PublisherNotFound extends RuntimeException{
    public PublisherNotFound(String message) {
        super(message);
    }
}
