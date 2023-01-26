package com.uz.library_api.controller.Genre;

import com.uz.library_api.model.Genre.DTO.GenreDTO;
import com.uz.library_api.model.Genre.Genre;
import com.uz.library_api.service.Genre.GenreService;
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
public class GenreController {
    private GenreService genreService;

    @GetMapping("/genre/all")
    public ResponseEntity<List<GenreDTO>> getAll() {
        log.info("Selected all genres user");
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/genre/{id}")
    public ResponseEntity<GenreDTO> getById(@PathVariable long id){
        log.info("Selected genre user with id " + id);
        return new ResponseEntity<>(genreService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/genre")
    public ResponseEntity<GenreDTO> getByName(@RequestParam String name){
        log.info("Selected genre user with name " + name);
        return new ResponseEntity<>(genreService.getByName(name), HttpStatus.OK);
    }
}

