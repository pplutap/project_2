package com.kodilla.ecommercee.cart.domain;


import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.product.domain.Product;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals(0, cart.getProductList().size());
    }

    @Test
    public void testGetOrderId() {
        //Given
        Order order = new Order();
        //When
        cart.setOrder(order);
        //Then
        assertNull(cart.getOrder().getOrderId());
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
    public void testSetOrderId() {
        //Given
        //When
        cart.setOrder(new Order());
        //Then
        assertEquals(null, cart.getOrder().getOrderId());
    }

    @Test
    public void setProductList() {
        //Given
        List<Product> list = new ArrayList<>();
        list.add(new Product());
        //When
        cart.setProductList(list);
        //Then
        assertEquals(1, cart.getProductList().size());
    }
}