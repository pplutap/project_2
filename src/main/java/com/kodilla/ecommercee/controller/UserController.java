package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exception.UserNotAuthorisedException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("getUser")
    public UserDto getUser(Long userId){
        return userService.getUser(userId);
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(Long userId){
        userService.deleteUser(userId);
    }

    @PostMapping(path = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @PutMapping("blockUser")
    public UserDto blockUser(@RequestParam Long userId) throws UserNotFoundException{
        return userService.blockUser(userId);
    }

    @GetMapping("getUniqueKey")
    public void getUniqueKey(@RequestParam Long userId, String userName) throws UserNotAuthorisedException, UserNotFoundException {
    }


}
