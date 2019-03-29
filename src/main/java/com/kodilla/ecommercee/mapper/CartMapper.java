package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartDto mapToCartDto(final Cart cart) {
        CartDto cartDto = new CartDto(cart.getCartId());
        cartDto.getProductsList().addAll(cart.getProductsList());
        return cartDto;
    }

    public Cart mapToCart(final CartDto cartDto) {
        Cart cart = new Cart(cartDto.getCartId());
        cart.getProductsList().addAll(cartDto.getProductsList());
        return cart;
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(cart -> mapToCartDto(cart))
                .collect(Collectors.toList());
    }
}
