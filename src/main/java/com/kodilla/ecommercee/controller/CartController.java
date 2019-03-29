package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartService cartService;

    @PostMapping(value = "createEmptyCart", consumes = APPLICATION_JSON_VALUE)
    public void createEmptyCart(@RequestBody CartDto cartDto) {
        cartService.createEmptyCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getElemementsFromEmptyCart")
    public List<Product> getProductsFromEmptyCart(@RequestParam Long cartId) {
        return cartService.getProductsFromCart(cartId);
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestBody Product product) {
        cartService.getProductsFromCart(cartId).add(product);
    }

    @PutMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestBody Product product) {
        cartService.getProductsFromCart(cartId).remove(product);
    }

    @GetMapping(value = "createOrder")
    public CartDto createOrder(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(cartService.getCart(cartId));
    }

    @GetMapping(value = "getAllCarts")
    public List<CartDto> getAllCarts() {
        return cartMapper.mapToCartDtoList(cartService.getAllCarts());
    }
}
