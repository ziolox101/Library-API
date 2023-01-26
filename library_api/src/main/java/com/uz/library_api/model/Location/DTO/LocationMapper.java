package com.uz.library_api.model.Location.DTO;

import com.uz.library_api.model.Location.Location;

import java.util.List;

public class LocationMapper {

    private LocationMapper(){}

    public static LocationDTO mapEntityToDto(Location location){
        return entityToDto(location);
    }

    public static Location mapDtoToEntity(LocationDTO dto){
        return dtoToEntity(dto);
    }

    public static List<LocationDTO> mapEntityListToDto(List<Location> locations){
        return entityListToDto(locations);
    }

    public static List<Location> mapDtoListToEntity(List<LocationDTO> dtoList){
        return dtoListToEntity(dtoList);
    }

    public static Location mapDtoRequestToEntity(LocationRequestDTO dto){
        return dtoRequestToEntity(dto);
    }
    private static LocationDTO entityToDto(Location location){
        return LocationDTO.builder()
                .numberOfRack(location.getNumberOfRack())
                .numberOfShelf(location.getNumberOfShelf())
                .build();
    }

    private static Location dtoToEntity(LocationDTO dto){
        return Location.builder()
                .numberOfRack(dto.getNumberOfRack())
                .numberOfShelf(dto.getNumberOfShelf())
                .build();
    }

    private static List<LocationDTO> entityListToDto(List<Location> locations){
        return locations.stream()
                .map(LocationMapper::entityToDto)
                .toList();
    }

    private static List<Location> dtoListToEntity(List<LocationDTO> dtoList){
        return dtoList.stream()
                .map(LocationMapper::dtoToEntity)
                .toList();
    }

    private static Location dtoRequestToEntity(LocationRequestDTO dto){
        return  Location.builder()
                .numberOfShelf(dto.getNumberOfShelf())
                .numberOfRack(dto.getNumberOfRack())
                .id(dto.getId())
                .build();
    }
}
