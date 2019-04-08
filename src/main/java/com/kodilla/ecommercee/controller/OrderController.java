package com.kodilla.ecommercee.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List <String> getOrders() {
        return new ArrayList <>();
    }

    @GetMapping(value = "getOrder")
    public String getOrder(@RequestParam int id) {
        return "order";
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam int id) {
    }

    @PutMapping(value = "updateOrder")
    public String updateOrder(@RequestBody String order) {
        return "updated order";
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody String order) {
    }
}
