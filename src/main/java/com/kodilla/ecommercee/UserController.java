package com.kodilla.ecommercee;


import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserById")
    public UserDto getUserById(final Long id) throws UserNotFoundException {
        return new UserDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteById(Long userId) {
        System.out.println("User is deleted.");
    }


    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userDto.setUuid(UUID.randomUUID().toString());
        userDto.setBeginValidityOfUuid(LocalTime.now());
        userDto.setEndValidityOfUuid(userDto.getBeginValidityOfUuid().plusHours(1));
        userDto.setBlocked(false);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "authorizationUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto authorizationUser(@RequestBody UserDto userDto, @RequestParam String key, @RequestParam String name, @RequestParam String password) {
        long duration = Duration.between(LocalTime.now(), userDto.getEndValidityOfUuid()).toHours();
        if (duration >= 1)
            userDto.setBlocked(true);
        if ((!(userDto.isBlocked())) && key.equals(userDto.getUuid()) && name.equals(userDto.getLogin()) && password.equals(userDto.getPassword())) {
            return new UserDto();

        } else {
            userDto.setBlocked(true);
            return new UserDto();

        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeKey", consumes = APPLICATION_JSON_VALUE)
    public UserDto changeKey(@RequestBody UserDto userDto, @RequestParam String name, @RequestParam String password) {
        if (userDto.isBlocked() && name.equals(userDto.getLogin()) && password.equals(userDto.getPassword())) {
            userDto.setUuid(UUID.randomUUID().toString());
            userDto.setBeginValidityOfUuid(LocalTime.now());
            userDto.setEndValidityOfUuid(userDto.getBeginValidityOfUuid().plusHours(1));
            userDto.setBlocked(false);
        }
        return new UserDto();

    }
}