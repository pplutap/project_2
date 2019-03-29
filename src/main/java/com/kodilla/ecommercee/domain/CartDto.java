package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class CartDto {
    private Long cartId;
    private List<Product> productsList = new ArrayList<>();

    public CartDto(Long cartId) {
        this.cartId = cartId;
    }

}
