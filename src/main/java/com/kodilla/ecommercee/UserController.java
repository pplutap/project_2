package com.kodilla.ecommercee;

import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalTime;
import java.util.List;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private DbUserService service;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToTaskDtoList(service.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserById")
    public UserDto getTaskById(final Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(service.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void delete(Long userId) {
        service.delete(userId);
    }


    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.generateKey(userMapper.mapToTask(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "authorizationUser", consumes = APPLICATION_JSON_VALUE)
    public void authorizationUser(@RequestBody UserDto userDto, @RequestParam String key, @RequestParam String name, @RequestParam String password) {
        service.keyDeliveryProcessIsPossible(userMapper.mapToTask(userDto), key, name, password);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeKey", consumes = APPLICATION_JSON_VALUE)
    public void changeKey(@RequestBody UserDto userDto, @RequestParam String name, @RequestParam String password) {
        service.changeKey(userMapper.mapToTask(userDto), name, password);
    }
}









