package com.kodilla.ecommercee.user.dao;

import com.kodilla.ecommercee.user.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {
    @Autowired
    UserDao userDao;

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
}
