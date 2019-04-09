package com.kodilla.ecommercee.order.domain;

import com.kodilla.ecommercee.product.domain.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class OrderTest {

    private Order testOrder = new Order();

    @Test
    public void testShouldGetOrderId() {
        //Given
        //When
        //Then
        Assert.assertEquals(null, testOrder.getOrderId());
    }

    @Test
    public void testShouldGetOrderDescription() {
        //Given
        //When
        //Then
        Assert.assertEquals(null, testOrder.getOrderDescription());
    }

    @Test
    public void testShouldGetProductList() {
        //Given
        //When
        //Then
        Assert.assertEquals(0, testOrder.getProductList().size());
    }

    @Test
    public void testShouldSetOrderId() {
        //Given
        //When
        testOrder.setOrderId(1L);
        //Then
        Assert.assertEquals(1L, testOrder.getOrderId(),0);
    }

    @Test
    public void testShouldSetOrderDescription() {
        //Given
        //When
        testOrder.setOrderDescription("Test");
        //Then
        Assert.assertEquals("Test", testOrder.getOrderDescription());
    }

    @Test
    public void testShouldSetProductList() {
        //Given
        List<Product> testProductList = new ArrayList<>();
        //When
        testOrder.setProductList(testProductList);
        //Then
        Assert.assertEquals(0, testOrder.getProductList().size());
    }
}
