package com.uz.library_api.controller.Genre;

import com.uz.library_api.model.Genre.DTO.GenreDTO;
import com.uz.library_api.model.Genre.DTO.GenreRequestDTO;
import com.uz.library_api.model.Genre.Genre;
import com.uz.library_api.service.Genre.GenreAdminService;
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
public class GenreAdminController {
    private GenreAdminService service;

    @GetMapping("/genre/all")
    public ResponseEntity<List<Genre>> getAll(){
        log.info("Selected all genres admin");
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/genre/{id}")
    public ResponseEntity<Genre> getById(@PathVariable long id){
        log.info("Selected genre admin " + id);
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    @GetMapping("/genre")
    public ResponseEntity<Genre> getByName(@RequestParam String name){
        log.info("Selected genre admin with name " + name);
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }
    @DeleteMapping("/genre/delete/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable long id){
        service.deleteGenre(id);
        log.info("Deleted genre with id " + id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping("/genre")
    public ResponseEntity<GenreDTO> addGenre(@RequestBody GenreDTO dto){
        log.info("Added genre admin " + dto.getName());
        return new ResponseEntity<>(service.addGenre(dto), HttpStatus.CREATED);
    }
    @PatchMapping("/genre")
    public ResponseEntity<GenreRequestDTO> editGenre(@RequestBody GenreRequestDTO dto){
        log.info("Edited genre with id " + dto.getId());
        return new ResponseEntity<>(service.editGenre(dto), HttpStatus.OK);
    }
}
