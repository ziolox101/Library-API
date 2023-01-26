package com.uz.library_api.model.User.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String name;
    private String surname;
    private String username;
    private String address;
    private String city;

}
