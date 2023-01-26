package com.uz.library_api.service.Location;

import com.uz.library_api.exceptions.Location.LocationIsTaken;
import com.uz.library_api.exceptions.Location.LocationNotFound;
import com.uz.library_api.model.Location.DTO.LocationDTO;
import com.uz.library_api.model.Location.DTO.LocationMapper;
import com.uz.library_api.model.Location.DTO.LocationRequestDTO;
import com.uz.library_api.model.Location.Location;
import com.uz.library_api.repository.LocationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {
    private LocationRepo locationRepo;

    public List<LocationDTO> getAll(){
        return LocationMapper.mapEntityListToDto(locationRepo.findAll());
    }

    public LocationDTO getLocationById(long id){
        return LocationMapper.mapEntityToDto(locationRepo.findById(id).orElseThrow(() -> new LocationNotFound("Location was not found")));
    }
}

