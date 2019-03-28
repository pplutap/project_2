package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;


public class CartDto {
    private Long cartId;
    private List<Product> productsList = new ArrayList<>();

    public CartDto() {

    }

    public CartDto(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }

    public List<Product> getProductsList() {
        return productsList;
    }
}
