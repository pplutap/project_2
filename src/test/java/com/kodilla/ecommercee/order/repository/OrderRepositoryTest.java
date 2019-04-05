package com.kodilla.ecommercee.order.repository;

import com.kodilla.ecommercee.order.domain.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testShouldFindAllOrders() {
        //Given
        Order testOrder = new Order();
        orderRepository.save(testOrder);
        //When
        List<Order> result = orderRepository.findAll();
        //Then
        Assert.assertEquals(1, result.size());
        //CleanUp
        orderRepository.delete(testOrder);
    }

    @Test
    public void testShouldSaveOrder() {
        //Given
        Order testOrder = new Order();
        //When
        orderRepository.save(testOrder);
        //Then
        Assert.assertEquals(1, orderRepository.count());
        //CleanUp
        orderRepository.delete(testOrder);
    }
}
