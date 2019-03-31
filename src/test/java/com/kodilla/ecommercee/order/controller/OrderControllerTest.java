package com.kodilla.ecommercee.order.controller;

import com.kodilla.ecommercee.order.domain.OrderDto;
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
    public void testShouldGetOrder() {

    }

    @Test
    public void testShouldCreateOrder() {
        //Given
        ProductDto product = new ProductDto();
        List<ProductDto> productList = new ArrayList<>();
        productList.add(product);
        OrderDto orderDto = new OrderDto(1L, "Test Order", productList);
        //When
        //Then
        Assert.assertEquals(1L, orderDto.getOrderId(), 0.01);
    }

    @Test
    public void testShouldUpdateOrder() {
        //Given
        ProductDto product = new ProductDto();
        ProductDto newProduct = new ProductDto(1L, "iPhone", "Mobile phone", 2799.00, 1L);
        List<ProductDto> productList = new ArrayList<>();
        productList.add(product);
        List<ProductDto> newProductList = new ArrayList<>();
        newProductList.add(newProduct);
        OrderDto orderDto = new OrderDto(1L, "Test Order", productList);
        //When
        OrderDto editedOrder = orderController.updateOrder(new OrderDto(1L, "Edited Test Order", newProductList));
        //Then
        Assert.assertNotEquals(orderDto, editedOrder);
        Assert.assertEquals("Edited Test Order", editedOrder.getOrderDescription());
    }

    @Test
    public void testShouldDeleteOrder() {
        //Given
        ProductDto product = new ProductDto();
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(product);
        OrderDto orderDto = new OrderDto(1L, "Test Order", productDtoList);
        List<OrderDto> orderDtoList = new ArrayList<>();
        orderDtoList.add(orderDto);
        //When
        orderController.deleteOrder(1L);
        //Then
        Assert.assertEquals(0, orderDtoList.size());
    }
}
