package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto(
                order.getName(),
                order.getDescription(),
                order.getProducts()
        );
        return orderDto;
    }

    public Order mapToOrder(OrderDto orderDto) {
        Order order = new Order(
                0L,
                orderDto.getName(),
                orderDto.getDescription(),
                orderDto.getProducts()
        );
        return order;
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        return orders.stream()
                .map(order -> new OrderDto(order.getName(), order.getDescription(), order.getProducts()))
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(List<OrderDto> dtoOrders) {
        return dtoOrders.stream()
                .map(order -> new Order(0L, order.getName(), order.getDescription(), order.getProducts()))
                .collect(Collectors.toList());
    }
}
