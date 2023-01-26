package com.uz.library_api.service.Book;

import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.Book.DTO.BookDto;
import com.uz.library_api.model.Book.DTO.BookMapper;
import com.uz.library_api.model.Genre.DTO.GenreDTO;
import com.uz.library_api.model.Genre.Genre;
import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import com.uz.library_api.model.Publisher.Publisher;
import com.uz.library_api.repository.BookRepo;
import com.uz.library_api.service.Author.AuthorService;
import com.uz.library_api.service.Genre.GenreService;
import com.uz.library_api.service.Publisher.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepo bookRepo;
    private GenreService genreService;
    private PublisherService publisherService;
    private AuthorService authorService;

    public List<BookDto> getAll(){
        return BookMapper.mapEntityListToDto(bookRepo.findAll());
    }

    public List<BookDto> getByLibraryName(String name){
        return BookMapper.mapEntityListToDto(bookRepo.findByLibrary_Name(name));
    }

    public List<BookDto> getByGenre(String genre){
        GenreDTO genreDTO = genreService.getByName(genre);
        return BookMapper.mapEntityListToDto(bookRepo.findByGenre_Name(genreDTO.getName()));
    }

    public List<BookDto> getByPublisher(String publisher){
        PublisherDto publisherDto = publisherService.getByName(publisher);
        return BookMapper.mapEntityListToDto(bookRepo.findByPublisher_Name(publisherDto.getName()));
    }

    public List<BookDto> getByAuthor(String name, String surname){
        AuthorDTO authorDTO = authorService.getByNameAndSurname(name, surname);
        return BookMapper.mapEntityListToDto(bookRepo.findByAuthor_NameAndAuthor_Surname(name, surname));
    }


}
