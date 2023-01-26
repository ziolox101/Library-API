package com.uz.library_api.exceptions.Location;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Location was not found")
public class LocationNotFound extends RuntimeException{
    public LocationNotFound(String message) {
        super(message);
    }
}
