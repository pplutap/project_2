package com.kodilla.ecommercee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<String> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public String getOrder() {
        return "Show the order";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public String updateOrder() {
        return "The order update";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder() {
    }
}
