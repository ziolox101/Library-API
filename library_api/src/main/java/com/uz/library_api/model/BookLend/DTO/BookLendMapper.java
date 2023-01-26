package com.uz.library_api.model.BookLend.DTO;

import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.Book.DTO.BookMapper;
import com.uz.library_api.model.BookLend.BookLend;
import com.uz.library_api.model.Library.DTO.LibraryMapper;
import com.uz.library_api.model.User.DTO.UserMapper;

import java.time.LocalDate;
import java.util.List;

public class BookLendMapper {
    private BookLendMapper(){
    }

    public static BookLendDTO mapEntityToDto(BookLend bookLend){
        return entityToDto(bookLend);
    }

    public static List<BookLendDTO> mapEntityListToDto(List<BookLend> lends){
        return entityListToDto(lends);
    }

    public static BookLendUserDTO mapEntityToUserDto(BookLend bookLend){
        return entityToUserDto(bookLend);
    }

    public static List<BookLendUserDTO> mapEntityListToUserDto(List<BookLend> bookLends){
        return entityListToUserDto(bookLends);
    }

    public static BookLend mapRequestDtoToEntity(BookLendRequest request){
        return requestDtoToEntity(request);
    }

    private static BookLendDTO entityToDto(BookLend bookLend){
        return BookLendDTO.builder()
                .from(bookLend.getFrom())
                .to(bookLend.getTo())
                .book(BookMapper.mapEntityToInfoDto(bookLend.getBook()))
                .user(UserMapper.entityToDto(bookLend.getUser()))
                .library(LibraryMapper.mapEntityToInfoDto(bookLend.getLibrary()))
                .build();
    }

    private static List<BookLendDTO> entityListToDto(List<BookLend> lends){
        return lends.stream()
                .map(BookLendMapper::entityToDto)
                .toList();
    }

    private static BookLendUserDTO entityToUserDto(BookLend bookLend){
        return BookLendUserDTO.builder()
                .from(bookLend.getFrom())
                .to(bookLend.getTo())
                .book(BookMapper.mapEntityToInfoDto(bookLend.getBook()))
                .library(LibraryMapper.mapEntityToInfoDto(bookLend.getLibrary()))
                .build();
    }

    private static List<BookLendUserDTO> entityListToUserDto(List<BookLend> bookLends){
        return bookLends.stream()
                .map(BookLendMapper::entityToUserDto)
                .toList();
    }

    private static BookLend requestDtoToEntity(BookLendRequest dto){
        return BookLend.builder()
                .to(LocalDate.now().plusMonths(1))
                .from(LocalDate.now())
                .build();
    }



}
