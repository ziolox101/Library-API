package com.uz.library_api.service.User;

import com.uz.library_api.exceptions.User.UserNotFoundException;
import com.uz.library_api.model.User.DTO.UserDTO;
import com.uz.library_api.model.User.DTO.UserMapper;
import com.uz.library_api.model.User.User;
import com.uz.library_api.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserAdminService {
    private UserRepo userRepo;

    public List<UserDTO> getAllUser(){
        return UserMapper.entityListToDto(userRepo.findAll());
    }

    public UserDTO getSingleUser(long id){
        return UserMapper.entityToDto(userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User was not found")));
    }

    public User getUserByLogin(String username){
       if(existsByUsername(username)){
           return userRepo.findByLogin(username);
       }
       else{
           throw new UserNotFoundException("User was not found");
       }
    }

    public void deleteUser(long id){
        userRepo.deleteById(id);
    }

    private boolean existsByUsername(String username){
        return userRepo.existsByLogin(username);
    }
}
