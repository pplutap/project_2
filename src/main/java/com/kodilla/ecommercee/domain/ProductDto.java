package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ProductDto {
    long id;
    String name;
    String description;
    BigDecimal price;
}
