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
    @Autowired
    ItemMapper itemMapper;

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(), itemMapper.mapToItemDtoList(cart.getItemsList()));
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getCartId(), itemMapper.mapToItemList(cartDto.getItemsList()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(cart -> new CartDto(cart.getCartId(), itemMapper.mapToItemDtoList(cart.getItemsList())))
                .collect(Collectors.toList());
    }
}
