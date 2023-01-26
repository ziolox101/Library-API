package com.uz.library_api.model.User.DTO;

import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.User.User;

import java.util.List;

public class UserMapper {


    public static UserDTO entityToDto(User user){
        return mapEntityToDto(user);
    }

    public static User DtoToEntity(UserDTO dto){
        return mapDtoToEntity(dto);
    }

    public static List<UserDTO> entityListToDto(List<User> dtoList){
        return mapEntityListToDto(dtoList);
    }

    public static List<User> dtoListToEntity(List<UserDTO> dtoList){
        return mapDtoListToEntity(dtoList);
    }

    public static User mapDtoRegisterToEntity(UserRegisterDTO dto){
        return dtoRegisterToEntity(dto);
    }
    private static UserDTO mapEntityToDto(User user){
        return UserDTO.builder()
                .city(user.getCity())
                .name(user.getName())
                .address(user.getAddress())
                .username(user.getLogin())
                .surname(user.getSurname())
                .build();
    }

    private static User mapDtoToEntity(UserDTO dto){
        return User.builder()
                .login(dto.getUsername())
                .address(dto.getAddress())
                .name(dto.getName())
                .city(dto.getCity())
                .surname(dto.getSurname())
                .build();
    }

    private static List<UserDTO> mapEntityListToDto(List<User> userList){
        return  userList.stream()
                .map(UserMapper::mapEntityToDto)
                .toList();
    }

    private static List<User> mapDtoListToEntity(List<UserDTO> dtoList){
        return dtoList.stream()
                .map(UserMapper::mapDtoToEntity)
                .toList();
    }

    private static User dtoRegisterToEntity(UserRegisterDTO dto){
        return User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .login(dto.getUsername())
                .password(dto.getPassword())
                .address(dto.getAddress())
                .city(dto.getCity())
                .role(dto.getRole())
                .build();
    }
}
