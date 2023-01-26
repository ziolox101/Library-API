package com.uz.library_api.model.Publisher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.BookLend.BookLend;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    @ToString.Exclude
    private List<Book> books;
}
