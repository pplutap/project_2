package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping("getUser")
    public UserDto getUser(@RequestParam Long userId) {
        return new UserDto(1L, "user1", false, 11L);
    }

    @PostMapping("createUser")
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userMapper.mapToUser(userDto));
    }

    @PutMapping("blockUser")
    public UserDto blockUser(@RequestParam Long userId, @RequestBody UserDto userDto) {
        return new UserDto(1L, "user2", true, 12L);
    }

    @GetMapping("generateUserIdKey")
    public Long generateUserIdKey(@RequestParam Long userId) {
        Long randomKey = new Random().nextLong();
        return userId + randomKey;
    }
}