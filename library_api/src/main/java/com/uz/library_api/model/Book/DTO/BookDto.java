package com.uz.library_api.model.Book.DTO;

import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.model.Genre.DTO.GenreDTO;
import com.uz.library_api.model.Library.DTO.LibraryDTO;
import com.uz.library_api.model.Library.DTO.LibraryInfoDTO;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.Location.DTO.LocationDTO;
import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import com.uz.library_api.model.Publisher.Publisher;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private String title;
    private long amount;
    private LibraryInfoDTO library;
    private AuthorDTO author;
    private GenreDTO genre;
    private LocationDTO location;
    private PublisherDto publisher;

}
