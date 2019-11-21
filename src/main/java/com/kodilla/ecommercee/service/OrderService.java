package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(OrderDto orderDto) {
        return orderRepository.save(orderMapper.mapToOrder(orderDto));
    }

    public OrderDto updateOrder(OrderDto orderDto, Long orderId) throws OrderNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);

        return orderMapper.mapToOrderDto(order);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
