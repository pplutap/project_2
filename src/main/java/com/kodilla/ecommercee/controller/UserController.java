package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {


    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return null;
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long userId) {
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
    }

    @PutMapping("/{userId}")
    public UserDto blockUser(@PathVariable Long userId) {
        return null;
    }

    @GetMapping("/getUniqueKey")
    public String getUniqueKey(@RequestParam Long userId, String userName) {
        return null;
    }
}
