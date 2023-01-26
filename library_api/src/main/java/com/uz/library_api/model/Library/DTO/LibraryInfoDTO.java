package com.uz.library_api.model.Library.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryInfoDTO {

    private String name;
    private String address;
    private String city;
}
