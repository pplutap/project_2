package com.kodilla.ecommercee;


import com.kodilla.ecommercee.cart.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ecommercee/user")
public class UserController {
    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public Long createUser(@RequestBody String userName) {
        UserDto userDto = new UserDto(1L, userName);
        return userDto.getUserId();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public Long blockUser(@RequestParam Long userId) {
        return userId;
    }

    @RequestMapping(method = RequestMethod.GET, value = "generateKey")
    public String generateKey(@RequestParam Long userId) {
        return "12345678qwertyuiop";
    }
}
