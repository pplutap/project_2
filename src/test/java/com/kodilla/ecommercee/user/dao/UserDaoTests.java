package com.kodilla.ecommercee.user.dao;

import com.kodilla.ecommercee.cart.dao.CartDao;
import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.order.repository.OrderRepository;
import com.kodilla.ecommercee.user.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserDaoTests {
    @Autowired
    UserDao userDao;

    @Autowired
    CartDao cartDao;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testSaveOne() {
        //Given
        User johnSmith = new User();
        johnSmith.setUserName("johnsmith");
        johnSmith.setStatus("1");
        johnSmith.setUserKey(12345L);

        //When
        userDao.save(johnSmith);
        long johnSmithId = johnSmith.getUserId();

        //Then
        Assert.assertNotEquals(0, johnSmithId);

        //Cleanup
        try {
            userDao.delete(johnSmith);
        } catch (Exception e) {
            System.out.println("Error during cleanup");
        }
    }

    @Test
    public void testSaveThree() {
        //Given
        User johnSmith = new User();
        johnSmith.setUserName("johnsmith");
        johnSmith.setStatus("1");
        johnSmith.setUserKey(12345L);

        User janeDoe = new User();
        janeDoe.setUserName("janedoe");
        janeDoe.setStatus("1");
        janeDoe.setUserKey(54321L);

        User clarkKent = new User();
        clarkKent.setUserName("clarkkent");
        clarkKent.setStatus("1");
        clarkKent.setUserKey(67890L);

        //When
        userDao.save(johnSmith);
        userDao.save(janeDoe);
        userDao.save(clarkKent);
        long userCount = userDao.count();

        //Then
        Assert.assertEquals(3, userCount);

        //Cleanup
        try {
            userDao.delete(johnSmith);
            userDao.delete(janeDoe);
            userDao.delete(clarkKent);
        } catch (Exception e) {
            System.out.println("Error during cleanup");
        }
    }

    @Test
    public void testFindAll() {
        //Given
        User johnSmith = new User();
        johnSmith.setUserName("johnsmith");
        johnSmith.setStatus("1");
        johnSmith.setUserKey(12345L);

        User janeDoe = new User();
        janeDoe.setUserName("janedoe");
        janeDoe.setStatus("1");
        janeDoe.setUserKey(54321L);

        User clarkKent = new User();
        clarkKent.setUserName("clarkkent");
        clarkKent.setStatus("1");
        clarkKent.setUserKey(67890L);

        //When
        userDao.save(johnSmith);
        userDao.save(janeDoe);
        userDao.save(clarkKent);
        List<User> users = userDao.findAll();

        //Then
        Assert.assertEquals(3, users.size());

        //Cleanup
        try {
            userDao.deleteAll(users);
        } catch (Exception e) {
            System.out.println("Error during cleanup");
        }
    }


    @Test
    public void testFindById() {
        //Given
        User johnSmith = new User();
        johnSmith.setUserName("johnsmith");
        johnSmith.setStatus("1");
        johnSmith.setUserKey(12345L);

        User janeDoe = new User();
        janeDoe.setUserName("janedoe");
        janeDoe.setStatus("1");
        janeDoe.setUserKey(54321L);

        User clarkKent = new User();
        clarkKent.setUserName("clarkkent");
        clarkKent.setStatus("1");
        clarkKent.setUserKey(67890L);

        //When
        userDao.save(johnSmith);
        userDao.save(janeDoe);
        userDao.save(clarkKent);
        Long johnSmithId = johnSmith.getUserId();
        Long janeDoeId = janeDoe.getUserId();
        Long clarkKentId = clarkKent.getUserId();

        User foundUser1 = userDao.findById(johnSmithId).get();
        User foundUser2 = userDao.findById(janeDoeId).get();
        User foundUser3 = userDao.findById(clarkKentId).get();

        //Then
        Assert.assertEquals("johnsmith", foundUser1.getUserName());
        Assert.assertEquals("janedoe", foundUser2.getUserName());
        Assert.assertEquals("clarkkent", foundUser3.getUserName());

        //Cleanup
        try {
            userDao.delete(johnSmith);
            userDao.delete(janeDoe);
            userDao.delete(clarkKent);
        } catch (Exception e) {
            System.out.println("Error during cleanup");
        }
    }

    @Test
    public void testSaveUserWithCarts() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cartDao.save(cart1);
        cartDao.save(cart2);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart1);
        carts.add(cart2);

        User johnSmith = new User();
        johnSmith.setUserName("johnSmith");
        johnSmith.setStatus("1");
        johnSmith.setUserKey(12345L);
        johnSmith.setCarts(carts);

        cart1.setUser(johnSmith);
        cart2.setUser(johnSmith);

        //When
        userDao.save(johnSmith);
        Long johnSmithId = johnSmith.getUserId();

        //Then
        Assert.assertEquals(1, userDao.count());
        Assert.assertEquals(2, userDao.findAll().get(0).getCarts().size());

        //CleanUp
        try {

            cartDao.delete(cart1);
            cartDao.delete(cart2);
            userDao.delete(johnSmith);
        } catch (Exception e) {
            System.out.println("Error during cleanup");
        }
    }

    @Test
    public void testSaveUserWithOrders() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        orderRepository.save(order1);
        orderRepository.save(order2);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        User johnSmith = new User();
        johnSmith.setUserName("johnSmith");
        johnSmith.setStatus("1");
        johnSmith.setUserKey(12345L);
        johnSmith.setOrders(orders);

        order1.setUser(johnSmith);
        order2.setUser(johnSmith);

        //When
        userDao.save(johnSmith);
        Long johnSmithId = johnSmith.getUserId();

        //Then
        Assert.assertEquals(1, userDao.count());
        Assert.assertEquals(2, userDao.findAll().get(0).getOrders().size());

        //CleanUp
        try {
            orderRepository.delete(order1);
            orderRepository.delete(order2);
            userDao.delete(johnSmith);
        } catch (Exception e) {
            System.out.println("Error during cleanup");
        }
    }
}
