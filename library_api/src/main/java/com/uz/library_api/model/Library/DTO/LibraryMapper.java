package com.uz.library_api.model.Library.DTO;

import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.User.DTO.UserMapper;
import com.uz.library_api.model.User.User;

import java.util.List;

public class LibraryMapper {

    private LibraryMapper(){}

    public static Library dtoToLibrary(LibraryDTO dto){
        return dtoToLibraryEntity(dto);
    }

    public static LibraryDTO libraryToDto(Library library){
        return entityToDTO(library);
    }

    public static List<LibraryDTO> entityListToDTO(List<Library> libraries){
        return entityListToDto(libraries);
    }

    public static LibraryInfoDTO mapEntityToInfoDto(Library library){
        return entityToInfoDto(library);
    }

    public static Library mapInfoDtoToEntity(LibraryInfoDTO dto){
        return infoDtoToEntity(dto);
    }

    public static Library mapRequestDtoToEntity(LibraryRequestDTO dto){
        return requestDtoToEntity(dto);
    }

    public static List<LibraryInfoDTO> mapEntityToInfoDtoList(List<Library> libraries){
        return entityToInfoDto(libraries);
    }

    public static List<Library> mapInfoDtoToEntityList(List<LibraryInfoDTO> dtoList){
        return infoDtoToEntityList(dtoList);
    }

    private static Library dtoToLibraryEntity(LibraryDTO dto){
        return Library.builder()
                .city(dto.getCity())
                .address(dto.getAddress())
                .name(dto.getName())
                .build();
    }
    private static LibraryDTO entityToDTO(Library library){
        return LibraryDTO.builder()
                .city(library.getCity())
                .address(library.getAddress())
                .name(library.getName())
                .users(UserMapper.entityListToDto(library.getUsers()))
                .build();
    }

    private static List<LibraryDTO> entityListToDto(List<Library> libraries){
        return libraries.stream()
                .map(LibraryMapper::libraryToDto)
                .toList();
    }

    private static LibraryInfoDTO entityToInfoDto(Library library){
        return LibraryInfoDTO.builder()
                .address(library.getAddress())
                .name(library.getName())
                .city(library.getCity())
                .build();
    }

    private static Library infoDtoToEntity(LibraryInfoDTO dto){
        return Library.builder()
                .city(dto.getCity())
                .name(dto.getName())
                .address(dto.getAddress())
                .build();
    }

    private static List<LibraryInfoDTO> entityToInfoDto(List<Library> libraries){
        return libraries.stream()
                .map(LibraryMapper::entityToInfoDto)
                .toList();
    }

    private static List<Library> infoDtoToEntityList(List<LibraryInfoDTO> dtos){
        return dtos.stream()
                .map(LibraryMapper::infoDtoToEntity)
                .toList();
    }

    private static Library requestDtoToEntity(LibraryRequestDTO dto){
        return Library.builder()
                .name(dto.getName())
                .id(dto.getId())
                .city(dto.getCity())
                .address(dto.getAddress())
                .build();
    }
}
