package com.uz.library_api.model.User.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterDTO {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String repeatPassword;
    private String address;
    private String city;
    private String library;
    @JsonIgnore
    private String role = "USER";
}
