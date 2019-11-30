package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public UserDto get(@PathVariable long userId){
        return userService.getUser(userId);
    }

    @DeleteMapping
    public void delete(@RequestParam long userId){
        userService.deleteUser(userId);
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @PutMapping("/{userId}")
    public UserDto blockUser(@RequestParam long userId){
        return userService.blockUser(userId);
    }

    @GetMapping("/uniqueKey")
    public Long getUniqueKey(@RequestParam long userId, @RequestParam String userName) {
        return userService.getUniqueKey(userId, userName);
    }
}
