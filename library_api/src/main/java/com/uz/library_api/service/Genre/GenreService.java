package com.uz.library_api.service.Genre;

import com.uz.library_api.exceptions.Genre.GenreExists;
import com.uz.library_api.exceptions.Genre.GenreNotFound;
import com.uz.library_api.model.Genre.DTO.GenreDTO;
import com.uz.library_api.model.Genre.DTO.GenreMapper;
import com.uz.library_api.model.Genre.DTO.GenreRequestDTO;
import com.uz.library_api.model.Genre.Genre;
import com.uz.library_api.repository.GenreRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private GenreRepo genreRepo;

    public List<GenreDTO> getAll() {
        return GenreMapper.mapEntityListToDto(genreRepo.findAll());
    }

    public GenreDTO getById(long id){
        return GenreMapper.mapEntityToDto(genreRepo.findById(id).orElseThrow(() -> new GenreNotFound("Genre was not found")));
    }

    public GenreDTO getByName(String name){
        if(existsByName(name)){
            return GenreMapper.mapEntityToDto(genreRepo.findByName(name));
        }
        else{
            throw new GenreNotFound("Genre with given name was not found");
        }
    }

    private boolean existsByName(String name){
        return genreRepo.existsByName(name);
    }
}
