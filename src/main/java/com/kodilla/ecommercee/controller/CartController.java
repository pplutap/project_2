package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "createCart")
    public void createCard(@RequestBody CartDto cartDto) {

    }

    @GetMapping(value = "getCart")
    public CartDto getCart(@RequestParam Long cartId){

        return new CartDto(1L);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "addItemToCart")
    public void addItemToCart(Long cartId, Long itemId){

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "deleteItemFromCart")
    public void deleteItemFromCart(Long cartId, Long itemId){

    }






}
