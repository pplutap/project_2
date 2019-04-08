package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        User user1 = new User("user1", false, 1L);
        User user2 = new User("user2", true, 2L);
        User user3 = new User("user3", false, 30L);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //When
        List<User> usersList = userRepository.findAll();

        //Then
        Assert.assertEquals(3, usersList.size());

    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        User user1 = new User("user1", false, 1L);
        User user2 = new User("user2", true, 2L);
        User user3 = new User("user3", false, 30L);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //When
        Optional<User> idTest = userRepository.findById(user3.getUserId());

        //Then
        Assert.assertEquals(Optional.of(user3), idTest);
    }

    @Transactional
    @Test
    public void testSave() {
        //Given
        User user1 = new User("user1", false, 1L);
        User user2 = new User("user2", true, 2L);
        User user3 = new User("user3", false, 30L);

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //Then
        Assert.assertEquals(3, userRepository.count());
    }
}
