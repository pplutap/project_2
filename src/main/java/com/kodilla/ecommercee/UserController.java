package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "users", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "users/{userId}")
    public UserDto lockUser(@PathVariable Long userId, @RequestParam boolean status) {
        return new UserDto(1L, "Piotr", status, 96997);
    }

    @RequestMapping(method = RequestMethod.POST, value = "users/{userId}/keys")
    public LoginDto generateKey(@PathVariable Long userId, @RequestParam String username, @RequestParam int userKey) {
        return new LoginDto(true, 12345);
    }

}
