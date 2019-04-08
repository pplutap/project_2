package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestSuite {

    @Autowired
    private UserService userService;

    @Transactional
    @Test
    public void testGetUsersList() {
        //Given
        User user1 = new User("user1", false, 1L);
        User user2 = new User("user2", true, 2L);
        User user3 = new User("user3", false, 3L);

        List<User> usersList = new ArrayList<>();

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);

        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);

        //When
        List<User> testUsersList = userService.getUsersList();

        //Then
        Assert.assertEquals(3, testUsersList.size());
        Assert.assertEquals(usersList.size(), testUsersList.size());
        Assert.assertEquals(usersList.get(1).getUserName(), testUsersList.get(1).getUserName());
    }

    @Transactional
    @Test
    public void testCreateUser() {
        //Given
        User user1 = new User("user1", false, 1L);
        User user2 = new User("user2", true, 2L);
        User user3 = new User("user3", false, 3L);

        //When
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);

        //Then
        Assert.assertEquals("user1", user1.getUserName());
        Assert.assertEquals(true, user2.getIsBlocked());
        Assert.assertEquals(3, userService.getUsersList().size());
    }

    @Transactional
    @Test
    public void testGetUser() {
        //Given
        User user1 = new User("user1", false, 1L);
        User user2 = new User("user2", true, 2L);
        User user3 = new User("user3", false, 3L);

        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);

        //When
        Optional<User> getUser1Test = userService.getUser(1L);
        Optional<User> getUser2Test = userService.getUser(2L);
        Optional<User> getUser3Test = userService.getUser(3L);

        //Then
        Assert.assertEquals(Optional.of(user1), getUser1Test);
        Assert.assertEquals(Optional.of(user2), getUser2Test);
        Assert.assertEquals(Optional.of(user3), getUser3Test);
    }
}
