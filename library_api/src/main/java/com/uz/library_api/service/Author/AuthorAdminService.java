package com.uz.library_api.service.Author;

import com.uz.library_api.exceptions.Author.AuthorExist;
import com.uz.library_api.exceptions.Author.AuthorNotFound;
import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.model.Author.DTO.AuthorMapper;
import com.uz.library_api.model.Author.DTO.AuthorRequestDTO;
import com.uz.library_api.repository.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorAdminService {
    private AuthorRepo authorRepo;

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author getAuthorById(long id) {
        return authorRepo.findById(id).orElseThrow(() -> new AuthorNotFound("Author was not found"));
    }

    public AuthorDTO addAuthor(AuthorDTO dto) {
        if(existsByNameAndSurname(dto.getName(), dto.getSurname())){
            throw new AuthorExist("Author already exist");
        }
        else {
            Author author = AuthorMapper.mapDtoToEntity(dto);
            authorRepo.save(author);
            return dto;
        }
    }
    public void deleteAuthor(long id){
        authorRepo.deleteById(id);
    }

    public AuthorRequestDTO editAuthor(AuthorRequestDTO dto){
        if(existsById(dto.getId())){
            Author author = AuthorMapper.mapDtoRequestToEntity(dto);
            authorRepo.save(author);
            return dto;
        }
        else{
            throw new AuthorNotFound("Author was not found");
        }
    }

    private boolean existsByNameAndSurname(String name, String surname){
        return authorRepo.existsByNameAndSurname(name, surname);
    }

    private boolean existsById(long id){
        return authorRepo.existsById(id);
    }
}
