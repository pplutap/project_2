package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("carts")
public class CartController {
    @GetMapping(name = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartID) {

        return new ArrayList<>();
    }
    @PutMapping(name="addProductToCart")
    public CartDto addProductToCart() {

        return new CartDto();
    }
    @PostMapping(name="createEmptyCart")
    public CartDto createEmptyCart() {

        return new CartDto();
    }
    @DeleteMapping(name="deleteProductFromCart")
    public void deleteProductFromCart() {

    }
    @PostMapping(name="createOrderFromCart")
    public OrderDto createOrderFromCart() {

        return new OrderDto();
    }
}


