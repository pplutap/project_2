package com.kodilla.ecommercee.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long groupId;

}
