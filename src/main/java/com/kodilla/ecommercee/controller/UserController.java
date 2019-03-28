package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
//        return userMapper.mapToUserDtoList(userService.getUsersList());
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId) throws UserNotFoundException {
//        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(UserNotFoundException::new));
        return new UserDto(1L, "user1", "Not Blocked", 11L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public UserDto blockUser(@RequestParam Long userId, @RequestBody UserDto userDto) {
//        return new UserDto(userId, userDto.getUserName(), "Blocked", userDto.getUserIdKey());
        return new UserDto(2L, "user2", "Blocked", 12L);
    }

    @RequestMapping(method = RequestMethod.GET, value = "generateUserIdKey")
    public Long generateUserIdKey(@RequestParam Long userId) throws UserNotFoundException {
        Long randomKey = new Random().nextLong();
        return userId + randomKey;
    }
}
