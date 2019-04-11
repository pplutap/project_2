package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderService.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderMapper.mapToOrder(orderDto));
    }
}
