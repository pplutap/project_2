package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping(value = "getOrder/{id}")
    public OrderDto getOrder(@PathVariable Long id ) throws OrderNotFoundException {
        return new OrderDto(1L, 199.99);
    }

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders(){
        List<OrderDto> orders = new ArrayList<>();
        orders.add(new OrderDto(1L,199.99));
        orders.add(new OrderDto(2L,49.00));
        return orders;
    }

    @PostMapping(value = "addOrder" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto addOrder(@RequestBody OrderDto orderDto){
        return orderDto;
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        return orderDto;
    }

    /**
     * Delete
     * Wymaga decyzji grupy jak chcemy zaprogramować
     * zachowanie systemu podczas próby usunięcia rekordu.
     * Raczej zmiana statusu niż samo 'fizyczne' usunięcie wpisu ?
     * **/
    @DeleteMapping(value = "deleteOrder/{id}")
    public void deleteOrder(@PathVariable Long id){

    }


}
