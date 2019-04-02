package com.kodilla.ecommercee.cart.domain;


import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.user.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart = new Cart();

    @Test
    public void testGetCartId() {
        //Given
        //When
        //Then
        assertEquals(null, cart.getCartId());
    }

    @Test
    public void testGetProducts() {
        //Given
        //When
        //Then
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testGetUsername() {
        //Given
        User user = new User();
        //When
        cart.setUsername(user);
        //Then
        assertNull(cart.getUsername());
    }

    @Test
    public void testGetOrderId() {
        //Given
        Order order = new Order();
        //When
        cart.setOrderId(order);
        //Then
        assertNull(cart.getOrderId());
    }

    @Test
    public void testSetCartId() {
        //Given
        //When
        cart.setCartId(12L);
        //Then
        assertTrue(cart.getCartId().equals(12L));
    }

    @Test
    public void testSetProductList() {
        //Given
        //When
        cart.setProductList(new Product(2L, "Test name", "Test desc", 13.2, 12L));
        //Then
        assertEquals(1, cart.getProducts().size());
        assertEquals("Test name", cart.getProducts().get(0));
    }

    @Test
    public void testSetUsername() {
        //Given
        //When
        cart.setUsername(new User(25L, "TestName", "Test", 13L));
        //Them
        assertEquals("TestName", cart.getUsername());
    }

    @Test
    public void testSetOrderId() {
        //Given
        //When
        cart.setOrderId(new Order(25L));
        //Then
        assertTrue(cart.getOrderId().equals(25L));
    }
}