package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDbService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CartDbService cartDbService;
    private final UserDbService userDbService;

    public Order createOrder(OrderDto orderDto) throws UserNotFoundException, CartNotFoundException {
        User user = userDbService.getOriginalUser(orderDto.getUserId());
        Cart cart = cartDbService.getOriginalCart(orderDto.getCartId());
        Order order = orderMapper.mapToOrder(orderDto, user, cart);

        return orderRepository.save(order);
    }

    public List<OrderDto> getOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderMapper.mapToOrderDtoList(orderList);
    }

    public OrderDto getOrderById(long id) throws OrderNotFoundException{
        Order order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return orderMapper.mapToOrderDto(order);
    }

    public List<Order> getOrdersBelongToUser(long userId) {
        return orderRepository.retrieveOrdersBelongToUser(userId);
    }

    public OrderDto updateOrder(long orderId, OrderStatus status) throws OrderNotFoundException,
            UserNotFoundException, CartNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        order.setStatus(status);
        OrderDto orderDto = orderMapper.mapToOrderDto(order);
        Order savedOrder = createOrder(orderDto);
        return orderMapper.mapToOrderDto(savedOrder);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

}
