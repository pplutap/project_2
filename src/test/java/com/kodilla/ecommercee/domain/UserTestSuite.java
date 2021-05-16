package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSavaUser(){
        //Given
        User user = new User("user",false);
        //When
        userRepository.save(user);
        //Then
        Long id = user.getId();
        Optional<User> checkUser = userRepository.findById(id);
        assertTrue(checkUser.isPresent());
        //CleanUp
        userRepository.deleteById(id);
    }
    @Test
    public void findByStatus(){
        //Given
        User user = new User("user",false);
        userRepository.save(user);
        boolean status = user.isStatus();
        //When
        List<User> checkStatus = userRepository.findByStatus(status);
        //Then
        assertEquals(1,checkStatus.size());

    }
}


