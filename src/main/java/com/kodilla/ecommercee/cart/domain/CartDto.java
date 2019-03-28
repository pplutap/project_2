package com.kodilla.ecommercee.cart.domain;

import java.util.List;

public class CartDto {
    private Long cartId;
    private List<ProductDto> productDtoList;
    private UserDto userDto;

    public CartDto(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public UserDto getUserDto() {
        return userDto;
    }
}
