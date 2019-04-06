package com.kodilla.ecommercee.cart.domain;


import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.user.domain.User;
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
        cart.setOrder(order);
        //Then
        assertNull(cart.getOrder().getOrderId());
    }

    @Test
    public void testGetItemsFromProductList() {
        //Given
        //When
        //Then
        assertEquals("", cart.getListOfProducts());
    }

    @Test
    public void testAddProductToProductList() {
        //Given
        //When
        cart.setListOfProducts(new Product(2L, "Test name", "Test desc", 13.2, 12L, new ArrayList<>()));
        //Then
        assertEquals("Test name", cart.getListOfProducts());
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
    public void testSetUsername() {
        //Given
        //When
        cart.setUsername(new User());
        //Them
        assertEquals(null, cart.getUsername());
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