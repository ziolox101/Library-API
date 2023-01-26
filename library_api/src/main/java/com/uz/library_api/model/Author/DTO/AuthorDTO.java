package com.uz.library_api.model.Author.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDTO {
    private String name;
    private String surname;
    private String bio;
}
