package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testOrderSave() {
        //Given
        User user = new User("user", false, "1234");
        Cart cart = new Cart();
        user.setRole("ADMIN");
        cart.setUser(user);
        userRepository.save(user);
        user.setCart(cart);
        cartRepository.save(cart);
        Order order = new Order(LocalDate.now(), OrderStatus.EXPECTING_PAYMENT,
                user, cart);

        //When
        orderRepository.save(order);

        //Then
        Long id = order.getOrderId();
        Optional<Order> readOrder = orderRepository.findById(id);
        assertTrue(readOrder.isPresent());

        //CleanUp
        orderRepository.deleteById(id);
        cartRepository.deleteById(cart.getCartId());
        userRepository.deleteById(order.getUser().getId());
    }
}
