package com.uz.library_api.controller.Location;


import com.uz.library_api.model.Location.DTO.LocationDTO;
import com.uz.library_api.model.Location.DTO.LocationRequestDTO;
import com.uz.library_api.model.Location.Location;
import com.uz.library_api.service.Location.LocationAdminService;
import com.uz.library_api.service.Location.LocationService;
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
public class LocationAdminController {
    private LocationAdminService locationService;

    @GetMapping("/location/all")
    public ResponseEntity<List<Location>> getAll(){
        log.info("Admin selected all locations");
        return new ResponseEntity<>(locationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<Location> getById(@PathVariable long id){
        log.info("Admin selected location with id " + id);
        return new ResponseEntity<>(locationService.getLocationById(id), HttpStatus.OK);
    }
    @PostMapping("/location")
    public ResponseEntity<LocationDTO> addLocation(@RequestBody LocationDTO dto){
        log.info("Admin adding location " + dto.getNumberOfShelf() + " " + dto.getNumberOfRack());
        return new ResponseEntity<>(locationService.addLocation(dto), HttpStatus.CREATED);
    }
    @PatchMapping("/location")
    public ResponseEntity<LocationRequestDTO> editLocation(@RequestBody LocationRequestDTO dto){
        log.info("Admin editing location with id " + dto.getId());
        return new ResponseEntity<>(locationService.editLocation(dto), HttpStatus.OK);
    }
    @DeleteMapping("/location/delete/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable long id){
        log.info("Admin deleting location with id " + id);
        locationService.deleteLocation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
