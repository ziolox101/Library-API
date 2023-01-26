package com.uz.library_api.model.Genre.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreRequestDTO {
    private long id;
    private String name;
}
