package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto, final User user, final Cart cart) {
        return new Order(
          orderDto.getOrderId(),
          orderDto.getOrderCreated(),
          orderDto.getStatus(),
          user,
          cart
        );
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getOrderCreated(),
                order.getStatus(),
                order.getUser().getId(),
                order.getCart().getId()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        orderList.forEach(order -> orderDtoList.add(mapToOrderDto(order)));
        return orderDtoList;
    }

}
