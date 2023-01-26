package com.uz.library_api.service.Author;

import com.uz.library_api.exceptions.Author.AuthorNotFound;
import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.model.Author.DTO.AuthorMapper;
import com.uz.library_api.repository.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepo authorRepo;

    public AuthorDTO getAuthorById(long id) {
        return AuthorMapper.mapEntityToDto(authorRepo.findById(id).orElseThrow(() -> new AuthorNotFound(String.valueOf(id))));
    }

    public AuthorDTO getByNameAndSurname(String name, String surname){
        if(existsByNameAndSurname(name, surname)){
            return AuthorMapper.mapEntityToDto(authorRepo.findByNameAndSurname(name, surname));
        }
        else{
            throw new AuthorNotFound("Author was not found");
        }
    }

    public List<AuthorDTO> getAllAuthors(){
        return AuthorMapper.mapEntityListToDto(authorRepo.findAll());
    }

    private boolean existsByNameAndSurname(String name, String surname){
        return authorRepo.existsByNameAndSurname(name, surname);
    }
}
