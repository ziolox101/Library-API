package com.uz.library_api.model.Publisher.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherRequestDTO {
    private long id;
    private String name;
}
