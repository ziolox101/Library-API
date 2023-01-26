package com.uz.library_api.controller.User;

import com.uz.library_api.model.User.DTO.UserDTO;
import com.uz.library_api.service.User.UserAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserAdminController {
    private UserAdminService userService;

    @GetMapping("/user/all")
    public List<UserDTO> getAll(){
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public UserDTO getSingleUser(@PathVariable long id){
        return userService.getSingleUser(id);
    }
}
