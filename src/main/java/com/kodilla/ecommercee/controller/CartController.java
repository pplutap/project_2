package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public CartDto createCart(@RequestBody CartDto cartDto) {
        return new CartDto(1L,1L, new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<GenericEntity> getProducts(@RequestParam Long cartId) {
        CartDto cartDto = new CartDto(1L,1L, new ArrayList<>());
        return cartDto.getProductsList();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addProducts")
    public void addProducts(@RequestParam Long cartId, @RequestParam List<GenericEntity> products) {
        CartDto cartDto = new CartDto(1L,1L, new ArrayList<>());
        cartDto.getProductsList().addAll(products);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId, @RequestParam Long cartId) {
        CartDto cartDto = new CartDto(1L,1L, new ArrayList<>());
        cartDto.getProductsList().removeIf(x -> x.getId().equals(productId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public GenericEntity createOrder(Long cartId) {
        return new GenericEntity(String.valueOf(cartId));
    }
}
