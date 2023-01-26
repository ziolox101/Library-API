package com.uz.library_api.model.Location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uz.library_api.model.Book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_of_rack")
    private long numberOfRack;
    @Column(name = "number_of_shelf")
    private long numberOfShelf;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    @ToString.Exclude
    private List<Book> books;
}
