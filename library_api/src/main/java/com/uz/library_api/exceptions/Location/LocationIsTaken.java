package com.uz.library_api.exceptions.Location;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Location is taken")
public class LocationIsTaken extends RuntimeException{
    public LocationIsTaken(String message) {
        super(message);
    }
}
