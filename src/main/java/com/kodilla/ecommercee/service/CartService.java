package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public List<Cart> getAllCarts() {
        return Optional.ofNullable(cartRepository.findAll()).orElse(new ArrayList<>());
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
