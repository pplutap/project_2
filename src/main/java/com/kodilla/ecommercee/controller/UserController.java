package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping(value = "createUser")
    public void createUser(UserDto userDto) {

    }

    @PutMapping(value = "blockUser")
    public void blockUser(Long userId) {

    }

    @GetMapping("generateKey")
    public int generateKey(UserDto userDto) {
        return 123;
    }
}
