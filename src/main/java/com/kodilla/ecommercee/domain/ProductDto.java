package com.kodilla.ecommercee.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private Group group;
}
