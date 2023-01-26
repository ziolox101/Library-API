package com.uz.library_api.model.Author.DTO;

import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Author.DTO.AuthorDTO;

import java.util.List;

public class AuthorMapper {
    private AuthorMapper() {
    }

    public static AuthorDTO mapEntityToDto(Author author){
        return authorToDTO(author);
    }

    public static Author mapDtoToEntity(AuthorDTO dto){
        return dtoToEntity(dto);
    }

    public static List<AuthorDTO> mapEntityListToDto(List<Author> authors){
        return entityListToDto(authors);
    }

    public static List<Author> mapDtoListToEntity(List<AuthorDTO> dtoList){
        return dtoListToEntity(dtoList);
    }

    public static Author mapDtoRequestToEntity(AuthorRequestDTO dto){
        return dtoRequestToEntity(dto);
    }

    private static AuthorDTO authorToDTO(Author author){
        return AuthorDTO.builder().name(author.getName())
                .surname(author.getSurname())
                .bio(author.getBio())
                .build();
    }

    private static Author dtoToEntity(AuthorDTO dto){
        return Author.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .bio(dto.getBio())
                .build();
    }

    private static List<AuthorDTO> entityListToDto(List<Author> authors){
        return authors.stream()
                .map(AuthorMapper::authorToDTO)
                .toList();
    }

    private static List<Author> dtoListToEntity(List<AuthorDTO> dtoList){
        return dtoList.stream()
                .map(AuthorMapper::dtoToEntity)
                .toList();
    }

    private static Author dtoRequestToEntity(AuthorRequestDTO dto){
        return Author.builder()
                .id(dto.getId())
                .bio(dto.getBio())
                .surname(dto.getSurname())
                .name(dto.getName())
                .build();
    }
}
