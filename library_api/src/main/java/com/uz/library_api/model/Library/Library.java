package com.uz.library_api.model.Library;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.BookLend.BookLend;
import com.uz.library_api.model.User.User;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "library")
    @ToString.Exclude
    private List<BookLend> lends;

    @JsonIgnore
    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    private List<Book> books;
}
