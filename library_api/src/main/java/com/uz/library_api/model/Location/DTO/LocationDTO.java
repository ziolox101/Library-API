package com.uz.library_api.model.Location.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LocationDTO {
    private long numberOfRack;
    private long numberOfShelf;
}
