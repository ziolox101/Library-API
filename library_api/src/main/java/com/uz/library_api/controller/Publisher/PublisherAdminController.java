package com.uz.library_api.controller.Publisher;

import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import com.uz.library_api.model.Publisher.DTO.PublisherRequestDTO;
import com.uz.library_api.model.Publisher.Publisher;
import com.uz.library_api.service.Publisher.PublisherAdminService;
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
public class PublisherAdminController {
    private PublisherAdminService service;

    @GetMapping("/publisher/all")
    public ResponseEntity<List<Publisher>> getAll(){
        log.info("Selected all publishers admin");
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/publisher/{id}")
    public ResponseEntity<Publisher> getById(@PathVariable long id){
        log.info("Selected admin publisher with id " + id);
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    @DeleteMapping("/publisher/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        log.info("Admin Deleted publisher with id " + id);
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/publisher")
    public ResponseEntity<PublisherDto> addPublisher(@RequestBody PublisherDto dto){
        log.info("Admin adding publisher " + dto.getName());
        return new ResponseEntity<>(service.addPublisher(dto), HttpStatus.CREATED);
    }
    @PatchMapping("/publisher")
    public ResponseEntity<PublisherDto> editPublisher(@RequestBody PublisherRequestDTO dto){
        log.info("Admin editing publisher with id " + dto.getId());
        return new ResponseEntity<>(service.editPublisher(dto), HttpStatus.OK);
    }
}
