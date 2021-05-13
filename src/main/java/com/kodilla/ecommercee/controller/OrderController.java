package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderStatus;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.OrderDbService;
import com.kodilla.ecommercee.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderDbService service;
    private final UserDbService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return service.getOrders();
    }

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto, @RequestParam Long key) throws UserNotFoundException, CartNotFoundException {
        if(userService.isKeyAssignedToUser(key)) {
            service.createOrder(orderDto);
        } else {
            LOGGER.error("Invalid key inserted");
        }
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam long orderId) throws OrderNotFoundException {
        return service.getOrderById(orderId);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestParam long orderId, @RequestParam OrderStatus status) throws CartNotFoundException,
            OrderNotFoundException, UserNotFoundException {
        return service.updateOrder(orderId, status);
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam long orderId) {
        service.deleteOrder(orderId);
    }
}
