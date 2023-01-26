package com.uz.library_api.service.Publisher;

import com.uz.library_api.exceptions.Publisher.PublisherExists;
import com.uz.library_api.exceptions.Publisher.PublisherNotFound;
import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import com.uz.library_api.model.Publisher.DTO.PublisherMapper;
import com.uz.library_api.model.Publisher.DTO.PublisherRequestDTO;
import com.uz.library_api.model.Publisher.Publisher;
import com.uz.library_api.repository.PublisherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherAdminService {
    private PublisherRepo publisherRepo;

    public List<Publisher> getAll(){
        return publisherRepo.findAll();
    }

    public Publisher getById(long id){
        return publisherRepo.findById(id).orElseThrow(() -> new PublisherNotFound("Publisher was not found"));
    }

    public void deleteById(long id){
        publisherRepo.deleteById(id);
    }

    public PublisherDto addPublisher(PublisherDto dto){
        if(existsByName(dto.getName())){
            throw new PublisherExists("Publisher exists by given name");
        }
        else {
            Publisher publisher = PublisherMapper.mapDtoToEntity(dto);
            publisherRepo.save(publisher);
            return dto;
        }
    }

    public PublisherDto editPublisher(PublisherRequestDTO dto){
        if(existsById(dto.getId())){
            Publisher publisher = PublisherMapper.mapDtoRequestToEntity(dto);
            return PublisherMapper.mapEntityToDto(publisherRepo.save(publisher));
        }
        else {
            throw new PublisherNotFound("Publisher was not found");
        }
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

    private boolean existsById(long id){
        return publisherRepo.existsById(id);
    }

}
