package com.uz.library_api.controller.Library;


import com.uz.library_api.model.Library.DTO.LibraryInfoDTO;
import com.uz.library_api.service.Library.LibraryInfoService;
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
public class LibraryController {
    private LibraryInfoService libraryService;

    @GetMapping("/library/{id}")
    public ResponseEntity<LibraryInfoDTO> getLibraryById(@PathVariable long id){
        log.info("Selected library with id: " + id);
        return new ResponseEntity<>(libraryService.getLibraryById(id), HttpStatus.OK);
    }

    @GetMapping("/library")
    public ResponseEntity<LibraryInfoDTO> getLibraryByName(@RequestParam String name){
        log.info("Selected library with name: " + name);
        return new ResponseEntity<>(libraryService.getLibraryByName(name), HttpStatus.OK);
    }

    @GetMapping("/library/all")
    public ResponseEntity<List<LibraryInfoDTO>> getAllLibraries(){
        return new ResponseEntity<>(libraryService.getAllLibraries(), HttpStatus.OK);
    }

}
