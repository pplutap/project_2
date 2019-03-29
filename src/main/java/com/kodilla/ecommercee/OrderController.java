package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/ecommercee/v1/order")
public class OrderController {
    private List <String> orders = new ArrayList <>(Arrays.asList("order1", "order2", "order3"));


    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List <String> getOrders() {
        return orders;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public String getOrder(@RequestParam int id) {
        String order = orders.get(id);
        return order;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam int id) {
        orders.remove(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public String updateOrder(@RequestBody String order) {
        return orders.set(0, order);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody String order) {
        orders.add(0, order);
    }
}
