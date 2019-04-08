package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/carts")
public class CartController {
    @GetMapping({"id"})
    public List<ProductDto> getProductsFromCart(@PathVariable("id") Long cartId) {
        return new ArrayList<>();
    }

    @PutMapping({"id"})
    public CartDto addProductToCart(@RequestBody CartDto cartDto, @PathVariable("id") Long cartId) {
        return new CartDto();
    }

    @PostMapping()
    public CartDto createEmptyCart() {
        return new CartDto();
    }

    @DeleteMapping({"id"})
    public void deleteProductFromCart(@PathVariable("id") Long productId, @RequestBody CartDto cartDto) {

    }

    @PostMapping()
    public OrderDto createOrderFromCart(@RequestBody CartDto cartDto) {
        return new OrderDto();
    }
}


