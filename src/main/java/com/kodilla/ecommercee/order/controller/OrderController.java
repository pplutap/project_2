package com.kodilla.ecommercee.order.controller;

import com.kodilla.ecommercee.order.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ecommercee/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long id) {
        return new OrderDto();
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {
        // TODO
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderDto;
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long id) {
        // TODO
    }
}
