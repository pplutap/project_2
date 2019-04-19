package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.service.OrderService;
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
    @Autowired
    OrderService orderService;

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(), itemMapper.mapToItemDtoList(cart.getItemsList()), getIdFromOrder(cart.getOrder()));
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getCartId(), itemMapper.mapToItemList(cartDto.getItemsList()), orderService.getOrder(cartDto.getOrderId()).orElse(null));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(cart -> new CartDto(cart.getCartId(), itemMapper.mapToItemDtoList(cart.getItemsList()), getIdFromOrder(cart.getOrder())))
                .collect(Collectors.toList());
    }
    private Long getIdFromOrder(Order order) {
        try {
            return order.getId();
        } catch (Exception e) {
            return null;
        }
    }
}
