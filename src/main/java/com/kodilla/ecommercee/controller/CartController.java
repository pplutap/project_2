package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/carts")
public class CartController {

    @PostMapping
    public void createCart(@RequestBody CartDto cartDto) {
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProductToCart")
    public void addProduct(@RequestBody CartDto cartDto) throws ProductNotFoundException {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "removeProductFromCart")
    public void removeProduct(@RequestBody CartDto cartDto) throws ProductNotFoundException {
    }

    @PostMapping("/create")
    public OrderDto createOrder(@RequestBody OrderDto orderDto, @RequestBody CartDto cartDto) {
        return null;
    }

}