package com.kodilla.ecommercee.cart.repository;

import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.order.repository.OrderRepository;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.product.repository.ProductRepository;
import com.kodilla.ecommercee.user.domain.User;
import com.kodilla.ecommercee.user.repository.UserRepository;
import org.apache.catalina.LifecycleState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTest {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    private Logger LOGGER = LoggerFactory.getLogger(CartRepositoryTest.class);

    @Before
    public void cleanUp() {
        try {
            cartRepository.deleteAll();
            userRepository.deleteAll();
            orderRepository.deleteAll();
            productRepository.deleteAll();
            LOGGER.info("CleanUp successful");
        } catch (Exception e) {
            LOGGER.error("CleanUp failed");
        }
    }

    @Test
    public void save() {
        //Given
        Cart cart = new Cart();
        //When
        cartRepository.save(cart);
        Optional<Cart> foundCart = cartRepository.findById(cart.getCartId());
        //Then
        assertEquals(cart.getCartId(), foundCart.get().getCartId());
    }

    @Test
    public void findById() {
        //Given
        Cart cart = new Cart();
        //When
        cartRepository.save(cart);
        Long foundCartId = cartRepository.findById(cart.getCartId()).get().getCartId();
        //Then
        assertNotNull(cartRepository.findById(cart.getCartId()));
        assertEquals(cart.getCartId(), foundCartId);
    }

    @Test
    public void shouldGiveOrder() {
        //Given
        Cart cart = new Cart();
        cartRepository.save(cart);

        Order order = new Order();
        order.setOrderDescription("Test");
        order.setCart(cart);

        //When
        orderRepository.save(order);
        String orderDesc = cartRepository.findById(cart.getCartId()).get().getOrder().getOrderDescription();

        //Then
        assertEquals(order.getOrderId(), cartRepository.findById(cart.getCartId()).get().getOrder().getOrderId(), 0.001);
        assertEquals("Test", orderDesc);
    }

    @Test
    public void shouldGiveUserId() {
        //Given
        User user = new User();
        userRepository.save(user);userRepository.save(user);userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(user);

        //When
        cartRepository.save(cart);
        Long userId = cartRepository.findById(cart.getCartId()).get().getUser().getUserId();
        System.out.println("************" + userId);

        //Then
        assertEquals(user.getUserId(), userId);
    }

}