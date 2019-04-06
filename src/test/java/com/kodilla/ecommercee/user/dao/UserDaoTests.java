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
        janeDoe.setUserName("janeDoe");
        janeDoe.setStatus("1");
        janeDoe.setUserKey(54321L);

        User clarkKent = new User();
        clarkKent.setUserName("clarkKent");
        clarkKent.setStatus("1");
        clarkKent.setUserKey(67890L);

        //When
        userDao.save(johnSmith);
        userDao.save(janeDoe);
        userDao.save(clarkKent);
        long userCount = userDao.count();
        List<User> users = userDao.findAll();

        //Then
        Assert.assertEquals(3, userCount);
        Assert.assertEquals(3, users.size());

        //Cleanup
        try {
            userDao.deleteAll(users);
        } catch (Exception e) {
            System.out.println("Error during cleanup");
        }
    }
}
