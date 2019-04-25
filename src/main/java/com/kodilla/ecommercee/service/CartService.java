package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) {
        Cart cart =  cartRepository.findById(cartId).orElse(new Cart());
        if (cart.getOrder() == null) {
            return cart;
        } else {
            return new Cart();
        }
    }

    public List<Cart> getAllCarts() {
        return Optional.ofNullable(cartRepository.findAll()).orElse(new ArrayList<>()).stream()
                .filter(cart -> cart.getOrder() == null)
                .collect(Collectors.toList());
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
