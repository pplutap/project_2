package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderStatus;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.OrderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException, CartNotFoundException {
            service.createOrder(orderDto);
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam long orderId) throws OrderNotFoundException {
        return service.getOrderById(orderId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestParam long orderId, @RequestParam OrderStatus status) throws CartNotFoundException,
            OrderNotFoundException, UserNotFoundException {
        return service.updateOrder(orderId, status);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam long orderId) {
        service.deleteOrder(orderId);
    }
}
