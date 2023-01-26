package com.uz.library_api.controller.Publisher;

import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import com.uz.library_api.service.Publisher.PublisherService;
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
public class PublisherController {
    private PublisherService publisherService;

    @GetMapping("/publisher/all")
    public ResponseEntity<List<PublisherDto>> getAll(){
        log.info("Selected all publishers user");
        return new ResponseEntity<>(publisherService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<PublisherDto> getById(@PathVariable long id){
        log.info("Selected user publisher with id " + id);
        return new ResponseEntity<>(publisherService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/publisher")
    public ResponseEntity<PublisherDto> getByName(@RequestParam String name){
        log.info("Selected user publisher with name " + name);
        return new ResponseEntity<>(publisherService.getByName(name), HttpStatus.OK);
    }
}
