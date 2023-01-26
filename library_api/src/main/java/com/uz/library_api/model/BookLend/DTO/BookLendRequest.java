package com.uz.library_api.model.BookLend.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookLendRequest {
  private String library;
  private long book;
}
