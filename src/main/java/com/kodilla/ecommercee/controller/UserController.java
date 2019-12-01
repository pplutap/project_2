package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/users")
public class UserController {


    @GetMapping("/{userId}")
    public UserDto get(@PathVariable long userId) {
        return null;
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable long userId) {
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
    }

    @PutMapping("/{userId}")
    public UserDto blockUser(@PathVariable long userId) {
        return null;
    }

    @GetMapping("/{userId}/uniqueKey")
    public Long getUniqueKey(@PathVariable long userId, @RequestParam String username) {
        return null;
    }
}
