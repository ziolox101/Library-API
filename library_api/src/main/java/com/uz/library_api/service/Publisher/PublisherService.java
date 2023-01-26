package com.uz.library_api.service.Publisher;


import com.uz.library_api.exceptions.Publisher.PublisherNotFound;
import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import com.uz.library_api.model.Publisher.DTO.PublisherMapper;
import com.uz.library_api.repository.PublisherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService {
    private PublisherRepo publisherRepo;

    public List<PublisherDto> getAll(){
        return PublisherMapper.mapDtoListToEntity(publisherRepo.findAll());
    }

    public PublisherDto getById(long id){
        return PublisherMapper.mapEntityToDto(publisherRepo.findById(id).orElseThrow(() -> new PublisherNotFound("Publisher was not found")));
    }

    public PublisherDto getByName(String name){
      if (existsByName(name)){
          return PublisherMapper.mapEntityToDto(publisherRepo.findPublisherByName(name));
      }
      else {
          throw new PublisherNotFound("Publisher was not found with given name");
      }
    }

    private boolean existsByName(String name){
        return publisherRepo.existsByName(name);
    }
}
