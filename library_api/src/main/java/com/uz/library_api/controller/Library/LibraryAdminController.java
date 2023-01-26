package com.uz.library_api.controller.Library;

import com.uz.library_api.model.Library.DTO.LibraryDTO;
import com.uz.library_api.model.Library.DTO.LibraryInfoDTO;
import com.uz.library_api.model.Library.DTO.LibraryRequestDTO;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.service.Library.LibraryAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
@Slf4j
public class LibraryAdminController {

    private LibraryAdminService libraryService;

    @PostMapping("/library")
    public ResponseEntity<LibraryInfoDTO> addLibrary(@RequestBody LibraryInfoDTO dto){
        log.info("Added library, name: " + dto.getName());
        return new ResponseEntity<>(libraryService.addLibrary(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/library/delete/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable long id){
        libraryService.deleteLibrary(id);
        log.info("Deleted library: " + id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/library")
    public ResponseEntity<LibraryInfoDTO> editLibrary(@RequestBody LibraryRequestDTO dto){
        log.info("Edited library with id: " + dto.getId());
        return new ResponseEntity<>(libraryService.editLibrary(dto), HttpStatus.OK);
    }
}
