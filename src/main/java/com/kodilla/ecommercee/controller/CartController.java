package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    private final CartDbService cartDbService;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    public CartController(CartDbService cartDbService, CartMapper cartMapper, ProductMapper productMapper) {
        this.cartDbService = cartDbService;
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "createCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCard(@RequestBody CartDto cartDto) throws UserNotFoundException {
        Cart cart = cartMapper.mapToCart(cartDto);
        cartDbService.saveCart(cart);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "getProductFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId) throws CartNotFoundException {
        return productMapper.mapToProductDtoList(cartDbService.getCartById(cartId).getProducts());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestParam Long productId) throws ProductNotFoundException, CartNotFoundException {
        cartDbService.addProductToCart(cartId, productId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "removeProductFromCart")
    public void removeProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) throws ProductNotFoundException, CartNotFoundException {
        cartDbService.deleteProductFromCart(cartId, productId);
    }
}
