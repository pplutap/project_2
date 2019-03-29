package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
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

    @GetMapping("getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping("getUser")
    public UserDto getUser(@RequestParam Long userId) {
        return new UserDto(1L, "user1", "Not Blocked", 11L);
    }

    @PostMapping("createUser")
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userMapper.mapToUser(userDto));
    }

    @PutMapping("blockUser")
    public UserDto blockUser(@RequestParam Long userId, @RequestBody UserDto userDto) {
        return new UserDto(2L, "user2", "Blocked", 12L);
    }

    @GetMapping("generateUserIdKey")
    public Long generateUserIdKey(@RequestParam Long userId) {
        Long randomKey = new Random().nextLong();
        return userId + randomKey;
    }
}
