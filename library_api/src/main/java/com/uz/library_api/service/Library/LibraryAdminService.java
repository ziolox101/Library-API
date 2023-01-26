package com.uz.library_api.service.Library;

import com.uz.library_api.exceptions.Library.LibraryBadRequest;
import com.uz.library_api.exceptions.Library.LibraryNotFound;
import com.uz.library_api.model.Library.DTO.LibraryInfoDTO;
import com.uz.library_api.model.Library.DTO.LibraryRequestDTO;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.Library.DTO.LibraryDTO;
import com.uz.library_api.model.Library.DTO.LibraryMapper;
import com.uz.library_api.repository.LibraryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibraryAdminService {
    private LibraryRepo libraryRepo;

    public List<LibraryDTO> getAll(){
        return LibraryMapper.entityListToDTO(libraryRepo.findAll());
    }

    public LibraryDTO getLibraryById(long id){
        return LibraryMapper.libraryToDto(libraryRepo.findById(id).orElseThrow(() -> new LibraryNotFound("Library was not found")));
    }

    public LibraryDTO getLibraryByNameToDto(String name) {
        return LibraryMapper.libraryToDto(Optional.ofNullable(libraryRepo.findByName(name)).orElseThrow(() -> new LibraryNotFound("Library was not found")));
    }

    public Library getLibraryByName(String name){
       return Optional.ofNullable(libraryRepo.findByName(name)).orElseThrow(() -> new LibraryNotFound("Library was not found"));
    }

    public LibraryInfoDTO addLibrary(LibraryInfoDTO dto){
        if(dto.getCity()!=null && dto.getName()!=null && dto.getAddress()!=null) {
            return LibraryMapper.mapEntityToInfoDto( libraryRepo.save(LibraryMapper.mapInfoDtoToEntity(dto)));
        }
        else{
            throw new LibraryBadRequest("Bad request to save library");
        }
    }

    public LibraryInfoDTO editLibrary(LibraryRequestDTO dto){
        if(libraryRepo.existsById(dto.getId())){
            Library library = LibraryMapper.mapRequestDtoToEntity(dto);
            return LibraryMapper.mapEntityToInfoDto(libraryRepo.save(library));
        }
        else{
            throw new LibraryBadRequest("Bad request to edit library");
        }
    }

    public void deleteLibrary(long id){
        libraryRepo.deleteById(id);
    }
}
