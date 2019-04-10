package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.UserService;
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
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

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

    @Transactional
    @Test
    public void testMapToUser() {

        //Given
        UserDto userDto1 = new UserDto(1L, "user1", true, 1L);
        UserDto userDto2 = new UserDto(2L, "user2", false, 2L);
        UserDto userDto3 = new UserDto(3L, "user3", true, 3L);

        //When
        User user1 = userMapper.mapToUser(userDto1);
        User user2 = userMapper.mapToUser(userDto2);
        User user3 = userMapper.mapToUser(userDto3);

        //Then
        Assert.assertEquals(user1.getUserName(), userDto1.getUserName());
        Assert.assertEquals(user2.getIsBlocked(), userDto2.getIsBlocked());
        Assert.assertEquals(user3.getUserIdKey(), userDto3.getUserIdKey());
    }

    @Transactional
    @Test
    public void testMapToUserDto() {

        //Given
        User user1 = new User("user1", true, 1L);
        User user2 = new User("user2", false, 2L);
        User user3 = new User("user3", true, 3L);

        //When
        UserDto userDto1 = userMapper.mapToUserDto(user1);
        UserDto userDto2 = userMapper.mapToUserDto(user2);
        UserDto userDto3 = userMapper.mapToUserDto(user3);

        //Then
        Assert.assertEquals(userDto1.getUserName(), user1.getUserName());
        Assert.assertEquals(userDto2.getIsBlocked(), user2.getIsBlocked());
        Assert.assertEquals(userDto3.getUserIdKey(), user3.getUserIdKey());
    }

    @Transactional
    @Test
    public void testMapToUserDtoList() {

        //Given
        User user1 = new User("user1", true, 1L);
        User user2 = new User("user2", false, 2L);
        User user3 = new User("user3", true, 3L);

        List<User> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);

        //When
        List<UserDto> usersDtoList = userMapper.mapToUserDtoList(usersList);

        //Then
        Assert.assertEquals(3, usersDtoList.size());
        Assert.assertEquals(usersList.size(), usersDtoList.size());
        Assert.assertEquals(usersList.get(1).getUserName(), usersDtoList.get(1).getUserName());
    }

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
}
