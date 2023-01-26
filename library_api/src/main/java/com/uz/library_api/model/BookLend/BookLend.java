package com.uz.library_api.model.BookLend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.User.User;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_lend")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookLend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "from_lend")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "to_lend")
    private LocalDate to;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "book_id_book_lend")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id_book_lend")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    private User user;
    @ManyToOne
    @JoinColumn(name = "library_id_book_lend")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ToString.Exclude
    private Library library;

}
