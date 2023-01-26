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
public class LocationAdminService {
    private LocationRepo locationRepo;

    public List<Location> getAll(){
        return locationRepo.findAll();
    }

    public Location getLocationById(long id){
        return locationRepo.findById(id).orElseThrow(() -> new LocationNotFound("Location was not found"));
    }

    public LocationDTO addLocation(LocationDTO dto){
        if(isTaken(dto.getNumberOfRack(), dto.getNumberOfShelf())){
            throw new LocationIsTaken("Location is already taken");
        }
        else{
            Location location = LocationMapper.mapDtoToEntity(dto);
            locationRepo.save(location);
            return dto;
        }
    }

    public LocationDTO getByNumberOfRackAndShelf(long rack, long shelf){
        if (isTaken(rack,shelf)){
            return LocationMapper.mapEntityToDto(locationRepo.getByNumberOfRackAndNumberOfShelf(rack,shelf));
        }
        else{
            throw new LocationNotFound("Location was not found");
        }
    }

    public LocationRequestDTO editLocation(LocationRequestDTO dto){
        if(existsById(dto.getId())){
            Location location = LocationMapper.mapDtoRequestToEntity(dto);
            locationRepo.save(location);
            return dto;
        }
        else{
            throw new LocationNotFound("Location was not found");
        }
    }

    public void deleteLocation(long id){
        locationRepo.deleteById(id);
    }

    boolean existsById(long id){
        return locationRepo.existsById(id);
    }

    boolean isTaken(long rack, long shelf){
        return locationRepo.existsByNumberOfRackAndNumberOfShelf(rack, shelf);
    }
}
