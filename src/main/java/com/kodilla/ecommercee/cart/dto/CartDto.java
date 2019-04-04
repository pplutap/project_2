package com.kodilla.ecommercee.cart.dto;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartDto {
    private Long cartId;
    private List<Product> productList;
    private User user;

    public CartDto(Long cartId) {
        this.cartId = cartId;
    }

}
