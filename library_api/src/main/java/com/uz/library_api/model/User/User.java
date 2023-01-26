package com.uz.library_api.model.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.uz.library_api.model.BookLend.BookLend;
import com.uz.library_api.model.Library.Library;
import lombok.*;


import javax.persistence.*;
import java.util.*;

@Entity()
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private String address;
    private String city;
    private String login;
    private String password;
    private String role;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id_user")
    @ToString.Exclude
    private Library library;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<BookLend> lends;



}
