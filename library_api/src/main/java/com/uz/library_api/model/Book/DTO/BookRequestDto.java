package com.uz.library_api.model.Book.DTO;

import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.model.Genre.DTO.GenreDTO;
import com.uz.library_api.model.Library.DTO.LibraryInfoDTO;
import com.uz.library_api.model.Location.DTO.LocationDTO;
import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDto {
    private String title;
    private long amount;
    private String library;
    private String authorName;
    private String authorSurname;
    private String genre;
    private long numberOfRack;
    private long numberOfShelf;
    private String publisher;
}
