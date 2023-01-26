package com.uz.library_api.model.Library.DTO;

import com.uz.library_api.model.User.DTO.UserDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryDTO {
    private String name;
    private String address;
    private String city;

    private List<UserDTO> users;
}
