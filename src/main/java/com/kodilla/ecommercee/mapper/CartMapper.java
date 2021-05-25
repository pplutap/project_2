package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.ProductDbService;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    UserDbService userDbService;

    public Cart mapToCart(CartDto cartDto) throws UserNotFoundException {
        User user = userDbService.getOriginalUser(cartDto.getUserId());
        return new Cart(
                cartDto.getCartId(),
                user
        );
    }
    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getCartId(),
                cart.getUser().getId()
        );
    }
    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
