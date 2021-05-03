package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @PostMapping(value = "createOrder")
    public void createOrder(OrderDto orderDto) {

    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(Long orderId) {
        return new OrderDto(1L);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(OrderDto orderDto) {
        return new OrderDto(1L);
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(Long orderId) {

    }
}
