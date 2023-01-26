package com.uz.library_api.model.Author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uz.library_api.model.Book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String bio;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private List<Book> books;

}
