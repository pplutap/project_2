package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ItemDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ItemMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ItemService;
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
    private ItemService itemService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ItemMapper itemMapper;

    @PostMapping(value = "saveCart", consumes = APPLICATION_JSON_VALUE)
    public CartDto saveCart(@RequestBody CartDto cartDto) {
        System.out.println(cartDto.toString());
        return cartMapper.mapToCartDto(cartService.saveCart(cartMapper.mapToCart(cartDto)));
    }

    @GetMapping(value = "getProductsFromCart")
    public List<ItemDto> getProductsFromCart(@RequestParam Long cartId) {
        return itemMapper.mapToItemDtoList(itemService.getAllItemsInCart(cartService.getCart(cartId)));
    }

    @PostMapping(value = "addProductToCart", consumes = APPLICATION_JSON_VALUE)
    public void addProductToCart(@RequestBody ItemDto itemDto) {
        itemService.saveItem(itemMapper.mapToItem(itemDto));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long itemId) {
        itemService.deleteItem(itemId);
    }

    @DeleteMapping(value = "deleteCart")
    public void deleteCart(@RequestParam Long cartId) {
        cartService.deleteCart(cartId);
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
