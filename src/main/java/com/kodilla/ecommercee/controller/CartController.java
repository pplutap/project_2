package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @PostMapping(value = "saveCart", consumes = APPLICATION_JSON_VALUE)
    public void saveCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(cartService.getCart(cartId)).getProductsList();
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestBody ProductDto productDto) {
        cartService.getCart(cartId).getProductsList().add(productMapper.mapToProduct(productDto));
    }

    @PutMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) throws ProductNotFoundException {
        cartService.getCart(cartId).getProductsList()
                .remove(productService.getProduct(productId)
                        .orElseThrow(ProductNotFoundException::new));
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
