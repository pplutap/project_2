package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.OrderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderDbService service;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return service.getOrders();
    }

    @PostMapping(value = "createOrder")
    public void createOrder(OrderDto orderDto) throws UserNotFoundException, CartNotFoundException {
        service.createOrder(orderDto);
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(Long orderId) throws OrderNotFoundException {
        return service.getOrderById(orderId);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(OrderDto orderDto) {
        return service.updateOrder();
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(Long orderId) {
        service.deleteOrder(orderId);
    }
}
