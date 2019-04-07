package com.kodilla.ecommercee.cart.repository;

import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.user.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTest {
    @Autowired
    CartRepository cartRepository;
    private Logger LOGGER = LoggerFactory.getLogger(CartRepositoryTest.class);

    @Test
    public void save() {
        //Given
        Cart cart = new Cart();
        cart.setCartId(3L);
        //When
        cartRepository.save(cart);
        //Then
        assertTrue(cart.getCartId().equals(3L));
        //CleanUp
        try {
            LOGGER.info("CleanUp successful");
            cartRepository.delete(cart);
        } catch (Exception e) {
            LOGGER.error("CleanUp failed");
        }
    }

    @Test
    public void findById() {
        //Given
        Cart cart = new Cart();
        cart.setCartId(3L);
        Optional<Cart> foundCart;
        //When
        cartRepository.save(cart);
        //Then
        try {
            LOGGER.info("CART FOUND");
            foundCart = cartRepository.findById(3L);
        } catch (Exception e) {
            LOGGER.error("CART NOT FOUND");
        }
        //CleanUp
        try {
            LOGGER.info("CleanUp successful");
            cartRepository.delete(cart);
        } catch (Exception e) {
            LOGGER.error("CleanUp failed");
        }
    }
}