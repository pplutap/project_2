package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.dto.CartDto;
import com.kodilla.ecommercee.controller.dto.OrderDto;
import com.kodilla.ecommercee.controller.dto.ProductDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carts")
public class CartController {
    @GetMapping(value =  "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartID) {
        return new ArrayList<>();
    }

    @PutMapping(value = "addProductToCart")
    public CartDto addProductToCart() {
        return new CartDto();
    }

    @PostMapping(value = "createEmptyCart")
    public CartDto createEmptyCart() {
        return new CartDto();
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart() {

    }

    @PostMapping(value = "createOrderFromCart")
    public OrderDto createOrderFromCart() {
        return new OrderDto();
    }
}


