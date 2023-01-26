package com.uz.library_api.service.Library;

import com.uz.library_api.exceptions.Library.LibraryNotFound;
import com.uz.library_api.model.Library.DTO.LibraryDTO;
import com.uz.library_api.model.Library.DTO.LibraryInfoDTO;
import com.uz.library_api.model.Library.DTO.LibraryMapper;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.repository.LibraryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibraryInfoService {
    private LibraryRepo libraryRepo;

    public LibraryInfoDTO getLibraryById(long id){
        return LibraryMapper.mapEntityToInfoDto(libraryRepo.findById(id).orElseThrow(() -> new LibraryNotFound("Library was not found")));
    }

    public LibraryInfoDTO getLibraryByName(String name) {
        return LibraryMapper.mapEntityToInfoDto(Optional.ofNullable(libraryRepo.findByName(name)).orElseThrow(() -> new LibraryNotFound("Library was not found")));
    }
    public List<LibraryInfoDTO> getAllLibraries(){
        return LibraryMapper.mapEntityToInfoDtoList(libraryRepo.findAll());
    }

}
