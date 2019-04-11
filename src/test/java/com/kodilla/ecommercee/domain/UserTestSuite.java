package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
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

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

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
        System.out.println(user1.getUserId());

        //Then
        Assert.assertEquals(3, usersList.size());

    }

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

    @Test
    public void testUserToUserDtoMapper() {
        //Given
        User user1 = new User("user1", false, 1L);

        userRepository.save(user1);

        //When
        Optional<User> user = userRepository.findById(user1.getUserId());
        UserDto userDtoRead = userMapper.mapToUserDto(Optional.ofNullable(user.get()).orElse(null));

        //Then
        Assert.assertEquals(user1.getUserId(), userDtoRead.getUserId());
        Assert.assertEquals(user1.getUserName(), userDtoRead.getUserName());
        Assert.assertEquals(user1.getUserIdKey(), userDtoRead.getUserIdKey());
        Assert.assertEquals(user1.getIsBlocked(), userDtoRead.getIsBlocked());
    }

    @Test
    public void testUserDtoToUserMapper() {
        //Given
        UserDto userDto = new UserDto(1L, "user1", false, 1L);

        //When
        User userMapping = userMapper.mapToUser(userDto);

        //Then
        Assert.assertEquals(userDto.getUserId(), userMapping.getUserId());
        Assert.assertEquals(userDto.getUserName(), userMapping.getUserName());
        Assert.assertEquals(userDto.getUserIdKey(), userMapping.getUserIdKey());
        Assert.assertEquals(userDto.getIsBlocked(), userMapping.getIsBlocked());
    }

    @Test
    public void testUserListToUserDtoListMapper() {
        //Given
        User user1 = new User("user1", false, 1L);
        User user2 = new User("user2", true, 2L);
        User user3 = new User("user3", false, 30L);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //When
        List<User> usersListRead = userRepository.findAll();
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(usersListRead);

        //Then
        for (int i = 0; i < usersListRead.size(); i++) {
            Assert.assertEquals(usersListRead.get(i).getUserId(), userDtoList.get(i).getUserId());
            Assert.assertEquals(usersListRead.get(i).getUserName(), userDtoList.get(i).getUserName());
            Assert.assertEquals(usersListRead.get(i).getUserIdKey(), userDtoList.get(i).getUserIdKey());
            Assert.assertEquals(usersListRead.get(i).getIsBlocked(), userDtoList.get(i).getIsBlocked());
        }
    }
}
