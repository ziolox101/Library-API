package com.uz.library_api.model.Book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.BookLend.BookLend;
import com.uz.library_api.model.Genre.Genre;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.Location.Location;
import com.uz.library_api.model.Publisher.Publisher;
import com.uz.library_api.model.User.User;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private long amount;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "library_id_book")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Library library;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    @JoinColumn(name = "author_id_book")
    private Author author;


    @ManyToOne
    @JoinColumn(name = "genre_id_book")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    private Genre genre;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "location_id_book")
    @ToString.Exclude
    private Location location;

    @ManyToOne
    @JoinColumn(name = "publisher_id_book")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    private Publisher publisher;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    private List<BookLend> bookLends;
}
