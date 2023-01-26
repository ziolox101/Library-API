package com.uz.library_api.model.Author.DTO;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequestDTO {
    private long id;
    private String name;
    private String surname;
    private String bio;
}
