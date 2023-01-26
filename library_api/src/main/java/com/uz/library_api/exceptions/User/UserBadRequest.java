package com.uz.library_api.exceptions.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Registration bad request")
public class UserBadRequest extends RuntimeException{
    public UserBadRequest(String message) {
        super(message);
    }
}
