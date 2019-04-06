package com.kodilla.ecommercee.order.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.user.domain.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class OrderTest {
    private Order order = new Order();

    @Test
    public void getOrderId() {
        //Given
        //When
        //Then
        assertEquals(null, order.getOrderId());
    }

    @Test
    public void getCart() {
        //Given
        //When
        //Then
        assertEquals(null, order.getCart());
    }

    @Test
    public void getOrderDescription() {
        //Given
        //When
        //Then
        assertEquals(null, order.getOrderDescription());
    }

    @Test
    public void setOrderId() {
        //Given
        //When
        order.setOrderId(25L);
        //Then
        assertTrue(order.getOrderId().equals(25L));
    }

    @Test
    public void setOrderDescription() {
        //Given
        //When
        order.setOrderDescription("Test");
        //Then
        assertEquals("Test", order.getOrderDescription());
    }

    @Test
    public void setCart() {
        //Given
        Cart cart = new Cart(25L, new ArrayList<>(), new User(), new Order());
        //When
        order.setCart(cart);
        //Then
        assertTrue(order.getCart().getCartId().equals(25L));
        assertEquals(0, order.getCart().getProductList().size());
        assertEquals(null, order.getCart().getOrder().getOrderId());
        assertEquals(null, order.getCart().getUser().getUserId());
    }
}