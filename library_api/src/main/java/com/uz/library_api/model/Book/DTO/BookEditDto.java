package com.uz.library_api.model.Book.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEditDto {
    private long id;
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
