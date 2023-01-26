package com.uz.library_api.controller.User;

import com.uz.library_api.model.User.DTO.UserDTO;
import com.uz.library_api.model.User.DTO.UserRegisterDTO;
import com.uz.library_api.model.User.User;
import com.uz.library_api.repository.UserRepo;
import com.uz.library_api.service.User.UserAdminService;
import com.uz.library_api.service.User.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> registerUser(@RequestBody UserRegisterDTO dto){
       UserRegisterDTO user =  userService.registerUser(dto);
       log.info("User has registered");
       return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
