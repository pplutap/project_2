package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
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

    @Autowired
    private ProductMapper productMapper;

    @PostMapping(value = "saveCart", consumes = APPLICATION_JSON_VALUE)
    public void saveCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getProductsFromCart")
    public List<Product> getProductsFromCart(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(cartService.getCart(cartId)).getProductsList();
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestBody ProductDto productDto) {
        cartService.getCart(cartId).getProductsList().add(productMapper.mapToProduct(productDto));
    }

    @PutMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestBody ProductDto productDto) {
        cartService.getCart(cartId).getProductsList().remove(productMapper.mapToProduct(productDto));
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
