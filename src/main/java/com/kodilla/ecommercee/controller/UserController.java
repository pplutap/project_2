package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping(value = "getUsers")
    public List<String> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getUser")
    public String getUserById(@RequestParam int userId) {
        return "user";
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteById(@RequestParam int userId) {
        System.out.println("User is deleted.");
    }

    @PostMapping(value = "createUser")
    public void createUser(@RequestBody String user) {

    }

    @PutMapping(value = "generateKey")
    public String authorizationUser(@RequestBody String key) {
        return UUID.randomUUID().toString();
    }

    @PutMapping(value = "blockingUser")
    public String blockingUser(@RequestBody String key) {
        return "User is blocking";
    }
}
