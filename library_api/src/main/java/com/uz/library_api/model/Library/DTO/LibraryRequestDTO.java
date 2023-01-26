package com.uz.library_api.model.Library.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryRequestDTO {
    private long id;
    private String name;
    private String address;
    private String city;

}
