package com.uz.library_api.controller.Common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessDeniedController {
    @GetMapping("/access-denied")
    public ResponseEntity<StringResponse> getAccessDenied() {
       return new  ResponseEntity<>(new StringResponse("you dont have access to this site"),HttpStatus.NOT_FOUND);

    }
}
