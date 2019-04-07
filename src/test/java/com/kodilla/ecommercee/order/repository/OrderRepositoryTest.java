package com.kodilla.ecommercee.order.repository;

import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.product.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void testShouldFindAllOrders() {
        //Given
        Order testOrder = new Order();
        Order testOrder2 = new Order();
        orderRepository.save(testOrder);
        orderRepository.save(testOrder2);

        //When
        List<Order> result = orderRepository.findAll();
        //Then
        Assert.assertEquals(2, result.size());
        //CleanUp
        orderRepository.delete(testOrder);
    }

    @Test
    public void testShouldSaveOrderWithProductList() {
        //Given
        Product testProduct1 = new Product();
        Product testProduct2 = new Product();
        List<Product> testProductList = new ArrayList<>();
        testProductList.add(testProduct1);
        testProductList.add(testProduct2);
        Order testOrder = new Order(1L, "Test", testProductList);
        //When
        orderRepository.save(testOrder);
        System.out.println(orderRepository.findById(1L).get().getProductList().size());
        //Then
        Assert.assertEquals(1, orderRepository.count());
        //CleanUp
        orderRepository.delete(testOrder);
    }
}