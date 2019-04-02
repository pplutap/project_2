package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.CartDto;
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

    @PostMapping(value = "saveCart", consumes = APPLICATION_JSON_VALUE)
    public void saveCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getProductsFromEmptyCart")
    public List<Product> getProductsFromEmptyCart(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(cartService.getCart(cartId)).getProductsList();
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestBody Product product) {
        cartMapper.mapToCartDto(cartService.getCart(cartId)).getProductsList().add(product);
    }

    @PutMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestBody Product product) {
        cartMapper.mapToCartDto(cartService.getCart(cartId)).getProductsList().remove(product);
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
