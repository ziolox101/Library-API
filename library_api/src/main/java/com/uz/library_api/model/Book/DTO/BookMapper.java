package com.uz.library_api.model.Book.DTO;

import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Author.DTO.AuthorMapper;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.Genre.DTO.GenreMapper;
import com.uz.library_api.model.Library.DTO.LibraryMapper;
import com.uz.library_api.model.Location.DTO.LocationDTO;
import com.uz.library_api.model.Location.DTO.LocationMapper;
import com.uz.library_api.model.Publisher.DTO.PublisherMapper;

import java.util.List;

public class BookMapper {

    public static BookDto mapEntityToDto(Book book) {
        return entityToDto(book);
    }

    public static List<BookDto> mapEntityListToDto(List<Book> books) {
        return entityListToDto(books);
    }

    public static BookInfoLendDTO mapEntityToInfoDto(Book book){
        return entityToInfoDto(book);
    }

    public static List<BookInfoLendDTO> mapEntityListToInfoDto(List<Book> books){
        return entityListToInfoDto(books);
    }

    public static Book mapRequestDtoToEntity(BookRequestDto dto){
        return dtoRequestToEntity(dto);
    }

    private static BookDto entityToDto(Book book) {
        return BookDto.builder()
                .title(book.getTitle())
                .amount(book.getAmount())
                .library(LibraryMapper.mapEntityToInfoDto(book.getLibrary()))
                .author(AuthorMapper.mapEntityToDto(book.getAuthor()))
                .genre(GenreMapper.mapEntityToDto(book.getGenre()))
                .location(LocationMapper.mapEntityToDto(book.getLocation()))
                .publisher(PublisherMapper.mapEntityToDto(book.getPublisher()))
                .build();
    }

    private static List<BookDto> entityListToDto(List<Book> books) {
        return books.stream()
                .map(BookMapper::entityToDto)
                .toList();
    }

    private static BookInfoLendDTO entityToInfoDto(Book book){
        return BookInfoLendDTO.builder()
                .title(book.getTitle())
                .author(AuthorMapper.mapEntityToDto(book.getAuthor()))
                .genre(GenreMapper.mapEntityToDto(book.getGenre()))
                .publisher(PublisherMapper.mapEntityToDto(book.getPublisher()))
                .build();
    }

    private static List<BookInfoLendDTO> entityListToInfoDto(List<Book> books){
        return books.stream()
                .map(BookMapper::entityToInfoDto)
                .toList();
    }

    private static Book dtoRequestToEntity(BookRequestDto dto){
        return Book.builder()
                .title(dto.getTitle())
                .amount(dto.getAmount())
                .build();
    }
}
