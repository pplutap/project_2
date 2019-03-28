package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void createEmptyCart(Cart cart) {
        cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) {
        return Optional.ofNullable(cartRepository.findByCartId(cartId)).orElse(null);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public List<Product> getProductsFromCart(Long cartId) {
        return cartRepository.findByCartId(cartId).getProductsList();
    }

}
