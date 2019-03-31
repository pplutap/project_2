
package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDto {
    private Cart cart;
    private final Long id;
    private final String name;
    private final Double price;
}

