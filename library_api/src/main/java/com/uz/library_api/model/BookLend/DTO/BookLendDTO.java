package com.uz.library_api.model.BookLend.DTO;

import com.uz.library_api.model.Book.DTO.BookDto;
import com.uz.library_api.model.Book.DTO.BookInfoLendDTO;
import com.uz.library_api.model.Library.DTO.LibraryDTO;
import com.uz.library_api.model.Library.DTO.LibraryInfoDTO;
import com.uz.library_api.model.User.DTO.UserDTO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class BookLendDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate to;
    private BookInfoLendDTO book;
    private UserDTO user;
    private LibraryInfoDTO library;
}
