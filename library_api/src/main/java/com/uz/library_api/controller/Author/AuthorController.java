package com.uz.library_api.controller.Author;

import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.service.Author.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class AuthorController {
    private AuthorService authorService;

    @GetMapping("/author/all")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){
        log.info("Selected all authors user");
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }
    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable long id){
        log.info("Select Author user with id" + id);
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<AuthorDTO> getAuthorByNameAndSurname(@RequestParam String name, @RequestParam String surname){
        log.info("Selected author with params " + name + " " + surname);
        return new ResponseEntity<>(authorService.getByNameAndSurname(name, surname), HttpStatus.OK);
    }
}
