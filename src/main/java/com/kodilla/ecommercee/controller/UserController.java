package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private BCryptPasswordEncoder passwordEncoder;

    private UserDbService service;

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) throws CartNotFoundException {
        service.createUser(userDto);
    }

    @PutMapping(value = "blockUser")
    public void blockUser(Long userId) {

    }

    @GetMapping("generateKey")
    public int generateKey(UserDto userDto) {
        return 123;
    }
}
