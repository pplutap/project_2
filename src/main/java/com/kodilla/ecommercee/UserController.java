package com.kodilla.ecommercee;


import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exception.UserNotAuthorisedException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public UserDto blockUser(@RequestParam Long UserId) throws UserNotFoundException {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUniqueKey")
    public void getUniqueKey(@RequestParam Long userId, String userName) throws UserNotAuthorisedException, UserNotFoundException {
    }
}
