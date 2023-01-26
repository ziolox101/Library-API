package com.uz.library_api.controller.Author;

import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.model.Author.DTO.AuthorRequestDTO;
import com.uz.library_api.service.Author.AuthorAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
@Slf4j
public class AuthorAdminController {
    private AuthorAdminService authorService;

    @GetMapping("/author/all")
    public ResponseEntity<List<Author>> getAll(){
        log.info("Selected all authors admin");
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getById(@PathVariable long id){
        log.info("Selected author admin with id " + id);
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }
    @PostMapping("/author")
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO author){
        log.info("Added author: " + author.toString());
        return new ResponseEntity<>(authorService.addAuthor(author), HttpStatus.OK);
    }
    @DeleteMapping("/author/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable long id){
        authorService.deleteAuthor(id);
        log.info("Author deleted " + id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/author")
    public ResponseEntity<AuthorRequestDTO> editAuthor(@RequestBody AuthorRequestDTO dto){
        log.info("Editing author: " + dto.toString());
        return new ResponseEntity<>(authorService.editAuthor(dto), HttpStatus.OK);
    }
}
