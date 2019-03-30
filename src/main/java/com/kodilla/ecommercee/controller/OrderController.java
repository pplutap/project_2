package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {
        return new OrderDto(1L, new Product(1L, "First product", 12.00), 12);
    }

    @GetMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        throw new UnsupportedOperationException("This operation is not yet supported.");
    }

    @GetMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, new Product(1L, "First product", 12.00), 23);
    }

    @GetMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        throw new UnsupportedOperationException("This operation is not yet supported.");
    }
}
