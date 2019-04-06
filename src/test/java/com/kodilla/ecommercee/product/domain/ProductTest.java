package com.kodilla.ecommercee.product.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductTest {
    private Product product = new Product(2L, "Test name", "Test desc", 13.2, 12L, new ArrayList<>());

    @Test
    public void getId() {
        //Given
        //When
        //Then
        assertTrue(product.getId().equals(2L));
    }

    @Test
    public void getName() {
        //Given
        //When
        //Then
        assertTrue(product.getName().equals("Test name"));
    }

    @Test
    public void getDescription() {
        //Given
        //When
        //Then
        assertTrue(product.getDescription().equals("Test desc"));
    }

    @Test
    public void getPrice() {
        //Given
        //When
        //Then
        assertTrue(product.getPrice().equals(13.2));
    }

    @Test
    public void getGroupId() {
        //Given
        //When
        //Then
        assertTrue(product.getGroupId().equals(12L));
    }

    @Test
    public void getCartList() {
        //Given
        //When
        //Then
        assertEquals(0, product.getCartList().size());
    }

    @Test
    public void setId() {
        //Given
        //When
        product.setId(25L);
        //Then
        assertTrue(product.getId().equals(25L));
    }

    @Test
    public void setName() {
        //Given
        //When
        product.setName("Test2");
        //Then
        assertTrue(product.getName().equals("Test2"));
    }

    @Test
    public void setDescription() {
        //Given
        //When
        product.setDescription("Test desc 2");
        //Then
        assertTrue(product.getDescription().equals("Test desc 2"));
    }

    @Test
    public void setPrice() {
        //Given
        //When
        product.setPrice(20.0);
        //Then
        assertTrue(product.getPrice().equals(20.0));
    }

    @Test
    public void setGroupId() {
        //Given
        //When
        product.setGroupId(18L);
        //Then
        assertTrue(product.getGroupId().equals(18L));
    }

    @Test
    public void setCartList() {
        //Given
        List<Cart> list = new ArrayList<>();
        //When
        list.add(new Cart());
        product.setCartList(list);
        //Then
        assertEquals(1, product.getCartList().size());
    }
}