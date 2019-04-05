package com.kodilla.ecommercee.user.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.order.domain.Order;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    private User user = new User();

    @Test
    public void getUserId() {
        //Given
        //When
        //Then
        assertEquals(null, user.getUserId());
    }

    @Test
    public void getUserName() {
        //Given
        //When
        //Then
        assertEquals(null, user.getUserName());
    }

    @Test
    public void getStatus() {
        //Given
        //When
        //Then
        assertEquals(null, user.getStatus());
    }

    @Test
    public void getUserKey() {
        //Given
        //When
        //Then
        assertEquals(null, user.getUserKey());
    }

    @Test
    public void getCart() {
        //Given
        //When
        //Then
        assertEquals(null, user.getUserId());
    }

    @Test
    public void setUserId() {
        //Given
        //When
        user.setUserId(25L);
        //Then
        assertTrue(user.getUserId().equals(25L));
    }

    @Test
    public void setUserName() {
        //Given
        //When
        user.setUserName("Test");
        //Then
        assertTrue(user.getUserName().equals("Test"));
    }

    @Test
    public void setStatus() {
        //Given
        //When
        user.setStatus("Test");
        //Then
        assertTrue(user.getStatus().equals("Test"));
    }

    @Test
    public void setUserKey() {
        //Given
        //When
        user.setUserKey(25L);
        //Then
        assertTrue(user.getUserKey().equals(25L));
    }

    @Test
    public void setCarts() {
        //Given
        //When
        user.setCarts(new ArrayList<>());
        //Then
        assertEquals(0, user.getCarts().size());
    }
}