package com.uz.library_api.exceptions.Publisher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Publisher exists")
public class PublisherExists extends RuntimeException {
    public PublisherExists(String message) {
        super(message);
    }
}
