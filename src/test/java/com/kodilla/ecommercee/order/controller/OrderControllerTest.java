package com.kodilla.ecommercee.order.controller;

import com.kodilla.ecommercee.order.dto.OrderDto;
import com.kodilla.ecommercee.product.dto.ProductDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderControllerTest {
    private OrderController orderController = new OrderController();

    @Test
    public void testShouldGetOrders() {
        //Given & When
        List<OrderDto> orderList = orderController.getOrders();
        //Then
        Assert.assertEquals(0, orderList.size());
    }

    @Test
    public void testShouldCreateOrder() {
        //Given
        ProductDto product = new ProductDto();
        List<ProductDto> productList = new ArrayList<>();
        productList.add(product);
        OrderDto orderDto = new OrderDto(1L, "Test Order", productList);
        //When
        String orderDescription = orderDto.getOrderDescription();
        //Then
        Assert.assertEquals("Test Order", orderDescription);
    }
}
