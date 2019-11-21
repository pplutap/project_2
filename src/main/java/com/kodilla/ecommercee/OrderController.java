package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/getOrders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public Order getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        return orderService.getOrderById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    @PostMapping(value = "/createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
    }

    @PutMapping(value = "/updateOrder/{orderId}")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto, @PathVariable Long orderId) throws OrderNotFoundException {
        return orderService.updateOrder(orderDto, orderId);
    }

    @DeleteMapping(value = "/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }
}
