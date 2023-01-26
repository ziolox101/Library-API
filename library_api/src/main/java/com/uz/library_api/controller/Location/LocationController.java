package com.uz.library_api.controller.Location;

import com.uz.library_api.model.Location.DTO.LocationDTO;
import com.uz.library_api.model.Location.Location;
import com.uz.library_api.service.Location.LocationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class LocationController {
    private LocationService locationService;

    @GetMapping("/location/all")
    public ResponseEntity<List<LocationDTO>> getAll(){
        log.info("User Selected All from location");
        return new ResponseEntity<>(locationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<LocationDTO> getById(@PathVariable long id){
        log.info("User selected location with id " + id);
        return new ResponseEntity<>(locationService.getLocationById(id), HttpStatus.OK);
    }
}
