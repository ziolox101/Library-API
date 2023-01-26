package com.uz.library_api.model.Genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uz.library_api.model.Book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    @ToString.Exclude
    private Set<Book> books;

}
