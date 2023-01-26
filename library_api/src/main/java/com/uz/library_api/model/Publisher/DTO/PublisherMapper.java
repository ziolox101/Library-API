package com.uz.library_api.model.Publisher.DTO;

import com.uz.library_api.model.Publisher.Publisher;

import java.util.List;

public class PublisherMapper {

    private PublisherMapper(){}

    public static PublisherDto mapEntityToDto(Publisher publisher){
        return entityToDto(publisher);
    }

    public static Publisher mapDtoToEntity(PublisherDto dto){
        return dtoToEntity(dto);
    }

    public static List<PublisherDto> mapDtoListToEntity(List<Publisher> publishers){
        return entityListToDto(publishers);
    }

    public static Publisher mapDtoRequestToEntity(PublisherRequestDTO dto){
        return dtoRequestToEntity(dto);
    }

    private static List<Publisher> mapEntityListToDto(List<PublisherDto> dtoList){
        return dtoListToEntity(dtoList);
    }

    private static PublisherDto entityToDto(Publisher publisher){
        return PublisherDto.builder()
                .name(publisher.getName())
                .build();
    }

    private static Publisher dtoToEntity(PublisherDto dto){
        return Publisher.builder()
                .name(dto.getName())
                .build();
    }

    private static List<PublisherDto> entityListToDto(List<Publisher> publishers){
       return publishers.stream()
                .map(PublisherMapper::entityToDto)
                .toList();
    }

    private static List<Publisher> dtoListToEntity(List<PublisherDto> dtoList){
        return dtoList.stream()
                .map(PublisherMapper::dtoToEntity)
                .toList();
    }

    private static Publisher dtoRequestToEntity(PublisherRequestDTO dto){
        return Publisher.builder()
                .name(dto.getName())
                .id(dto.getId())
                .build();
    }
}
