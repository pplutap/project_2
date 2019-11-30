package com.kodilla.ecommercee.controller;

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

    @PostMapping("/{productId}")
    public void addProduct(@RequestParam Long cartId, @PathVariable Long productId) throws ProductNotFoundException {
    }

    @DeleteMapping("/{productId}")
    public void removeProduct(@RequestParam Long cartId, @PathVariable Long productId) throws ProductNotFoundException {
    }

    @PostMapping("/create")
    public OrderDto createOrder(@RequestBody OrderDto orderDto, @RequestBody CartDto cartDto) {
        return null;
    }
}