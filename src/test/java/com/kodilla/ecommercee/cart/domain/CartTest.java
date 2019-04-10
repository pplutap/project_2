package com.kodilla.ecommercee.cart.domain;


import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;


public class CartTest {
    private Cart cart = new Cart();

    @Test
    public void getCartId() {
        assertEquals(null, cart.getCartId());
    }

    @Test
    public void getProductList() {
        assertEquals(new ArrayList<>(), cart.getProductList());
    }

    @Test
    public void getUserDto() {
        assertEquals(null, cart.getUser());
    }
}