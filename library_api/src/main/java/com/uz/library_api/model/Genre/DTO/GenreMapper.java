package com.uz.library_api.model.Genre.DTO;

import com.uz.library_api.model.Genre.Genre;

import java.util.List;
import java.util.stream.Stream;

public class GenreMapper {

    public static GenreDTO mapEntityToDto(Genre genre){
        return entityToDto(genre);
    }

    public static Genre mapDtoToEntity(GenreDTO dto){
        return dtoToEntity(dto);
    }

    public static List<GenreDTO> mapEntityListToDto(List<Genre> genres){
        return entityListToDto(genres);
    }

    public static List<Genre> mapDtoListToEntity(List<GenreDTO> dtoList){
        return dtoListToEntity(dtoList);
    }

    public static Genre mapDtoRequestToEntity(GenreRequestDTO dto){
        return dtoRequestToEntity(dto);
    }
    private static GenreDTO entityToDto(Genre genre){
        return GenreDTO.builder()
                .name(genre.getName())
                .build();
    }

    private static Genre dtoToEntity(GenreDTO dto){
        return Genre.builder()
                .name(dto.getName())
                .build();
    }

    private static List<GenreDTO> entityListToDto(List<Genre> genres){
        return genres.stream()
                .map(GenreMapper::entityToDto)
                .toList();
    }

    private static List<Genre> dtoListToEntity(List<GenreDTO> dtoList){
        return dtoList.stream()
                .map(GenreMapper::dtoToEntity)
                .toList();
    }

    private static Genre dtoRequestToEntity(GenreRequestDTO dto){
        return Genre.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}

