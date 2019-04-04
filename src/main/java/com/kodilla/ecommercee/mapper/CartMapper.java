package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    @Autowired
    ProductMapper productMapper;

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(), productMapper.mapToProductDtoList(cart.getProductsList()));
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getCartId(), productMapper.mapToProductList(cartDto.getProductsList()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(cart -> new CartDto(cart.getCartId(), productMapper.mapToProductDtoList(cart.getProductsList())))
                .collect(Collectors.toList());
    }
}
