package com.uz.library_api.controller;

import com.uz.library_api.model.MessageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultEndpoint {

    @GetMapping("/")
    public MessageDto hello(){
        return new MessageDto("User has logged in");
    }
}
