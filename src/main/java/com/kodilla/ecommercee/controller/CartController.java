package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ItemService;
import com.kodilla.ecommercee.service.ProductService;
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

    @Autowired
    ProductService productService;

    @Autowired
    ItemService itemService;

    @PostMapping(value = "saveCart", consumes = APPLICATION_JSON_VALUE)
    public void saveCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getProductsFromCart")
    public CartDto getProductsFromCart(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(cartService.getCart(cartId));
    }

    @PutMapping(value = "addProductToCart")
    public CartDto addProductToCart(@RequestParam Long cartId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.getCart(cartId).getItemsList().add(new Item(cartService.getCart(cartId), productService.getProduct(productId), quantity));
        return cartMapper.mapToCartDto(cartService.saveCart(cartService.getCart(cartId)));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
        itemService.deleteByCartAndItem(cartService.getCart(cartId), productService.getProduct(productId));
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