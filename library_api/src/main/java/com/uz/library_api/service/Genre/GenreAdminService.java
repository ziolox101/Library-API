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
public class GenreAdminService {
    private GenreRepo genreRepo;

    public List<Genre> getAll() {
        return genreRepo.findAll();
    }

    public Genre getById(long id){
        return genreRepo.findById(id).orElseThrow(() -> new GenreNotFound("Genre was not found"));
    }

    public Genre getByName(String name){
        if(existsByName(name)){
            return genreRepo.findByName(name);
        }
        else{
            throw new GenreNotFound("Genre with given name was not found");
        }
    }

    public void deleteGenre(long id){
        genreRepo.deleteById(id);
    }

    public GenreDTO addGenre(GenreDTO dto){
        if(existsByName(dto.getName())){
            throw new GenreExists("Genre already exists");
        }
        else{
            Genre genre = GenreMapper.mapDtoToEntity(dto);
            genreRepo.save(genre);
            return dto;
        }
    }

    public GenreRequestDTO editGenre(GenreRequestDTO dto){
        if(existsById(dto.getId())){
            Genre genre = GenreMapper.mapDtoRequestToEntity(dto);
            genreRepo.save(genre);
            return dto;
        }
        else{
            throw new GenreExists("Genre with given name exists");
        }
    }

    private boolean existsById(long id){
        return genreRepo.existsById(id);
    }

    private boolean existsByName(String name){
        return genreRepo.existsByName(name);
    }
}
