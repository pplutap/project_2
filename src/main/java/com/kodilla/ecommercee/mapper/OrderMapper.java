package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ProductService;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                cartService.getCart(orderDto.getCartId()),
                userService.getUser(orderDto.getUserId()).orElse(null));
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getCart().getCartId(),
                order.getUser().getUserId());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(t -> new OrderDto(t.getId(), t.getCart().getCartId(), t.getUser().getUserId()))
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(final List<OrderDto> orderDtoList) {
        return orderDtoList.stream()
                .map(t -> new Order(t.getId(), cartService.getCart(t.getCartId()), userService.getUser(t.getUserId()).orElse(null)))
                .collect(Collectors.toList());
    }

}
