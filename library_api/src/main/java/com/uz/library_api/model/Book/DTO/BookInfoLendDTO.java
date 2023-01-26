package com.uz.library_api.model.Book.DTO;

import com.uz.library_api.model.Author.DTO.AuthorDTO;
import com.uz.library_api.model.Genre.DTO.GenreDTO;
import com.uz.library_api.model.Location.DTO.LocationDTO;
import com.uz.library_api.model.Publisher.DTO.PublisherDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookInfoLendDTO {
    private String title;
    private AuthorDTO author;
    private GenreDTO genre;
    private PublisherDto publisher;
}
