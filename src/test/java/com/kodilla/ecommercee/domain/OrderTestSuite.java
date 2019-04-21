package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.OrderService;
import com.kodilla.ecommercee.service.ProductService;
import com.kodilla.ecommercee.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @Test
    public void testGetAllOrders() {
        //Given
        Product product1 = new Product("Product1", 25.6);
        productService.saveProductOrUpdate(product1);
        Cart cart1 = new Cart();
        Item item1 = new Item(cart1, product1, 22);
        cart1.getItemsList().add(item1);
        cartService.saveCart(cart1);
        Product product2 = new Product("Product2", 22.0);
        productService.saveProductOrUpdate(product2);
        Cart cart2 = new Cart();
        Item item2 = new Item(cart2, product2, 19);
        cart2.getItemsList().add(item2);
        cartService.saveCart(cart2);
        User user1 = new User("User1", false, 1L);
        User user2 = new User("User2", false, 2L);
        userService.saveUser(user1);
        userService.saveUser(user2);
        Order order1 = new Order(1L, cart1, user1);
        orderService.saveOrder(order1);
        Order order2 = new Order(2L, cart2, user2);
        orderService.saveOrder(order2);
        //When
        List<Order> orderList = orderService.getAllOrders();
        //Then
        Assert.assertEquals(2, orderList.size());
        Assert.assertEquals(product1, orderList.get(0).getCart().getItemsList().get(0).getProduct());
        Assert.assertEquals(product2, orderList.get(1).getCart().getItemsList().get(0).getProduct());
        Assert.assertEquals(user1, orderList.get(0).getUser());
        Assert.assertEquals(user2, orderList.get(1).getUser());
    }

    @Test
    public void testGetOrder() {
        //Given
        Product product1 = new Product("Product1", 25.6);
        productService.saveProductOrUpdate(product1);
        Cart cart1 = new Cart();
        Item item1 = new Item(cart1, product1, 22);
        cart1.getItemsList().add(item1);
        cartService.saveCart(cart1);
        User user1 = new User("User1", false, 1L);
        userService.saveUser(user1);
        Order order1 = new Order(cart1, user1);
        orderService.saveOrder(order1);
        //When
        Long order1Id = order1.getId();
        Order receivedOrder1 = orderService.getOrder(order1Id).orElse(null);
        //Then
        Assert.assertEquals(order1, receivedOrder1);
        Assert.assertEquals(user1, receivedOrder1.getUser());
        Assert.assertEquals(cart1, receivedOrder1.getCart());
    }

    @Test
    public void testSaveOrder() {
        //Given
        Product product1 = new Product("Product1", 25.6);
        productService.saveProductOrUpdate(product1);
        Cart cart1 = new Cart();
        Item item1 = new Item(cart1, product1, 22);
        cart1.getItemsList().add(item1);
        cartService.saveCart(cart1);
        User user1 = new User("User1", false, 1L);
        userService.saveUser(user1);
        List<Order> orderList = orderService.getAllOrders();
        Order order1 = new Order(cart1, user1);
        orderService.saveOrder(order1);
        //When
        List<Order> orderListAfterSave = orderService.getAllOrders();
        int id = orderService.getAllOrders().indexOf(order1);
        Long order1Id = orderService.getAllOrders().get(id).getId();
        Order receivedOrder1 = orderService.getOrder(order1Id).orElse(null);
        //Then
        Assert.assertEquals(order1, receivedOrder1);
        Assert.assertEquals(0, orderList.size());
        Assert.assertEquals(1, orderListAfterSave.size());
    }

    @Test
    public void testDeleteOrder() {
        //Given
        Product product1 = new Product("Product1", 25.6);
        productService.saveProductOrUpdate(product1);
        Cart cart1 = new Cart();
        Item item1 = new Item(cart1, product1, 22);
        cart1.getItemsList().add(item1);
        cartService.saveCart(cart1);
        User user1 = new User("User1", false, 1L);
        userService.saveUser(user1);
        Order order1 = new Order(cart1, user1);
        orderService.saveOrder(order1);
        List<Order> orderList = orderService.getAllOrders();
        //When
        int id = orderService.getAllOrders().indexOf(order1);
        Long order1Id = orderService.getAllOrders().get(id).getId();
        orderService.deleteOrder(order1Id);
        List<Order> orderListAfterDelete = orderService.getAllOrders();
        //Then
        Assert.assertEquals(1, orderList.size());
        Assert.assertEquals(0, orderListAfterDelete.size());
    }
}
