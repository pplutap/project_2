package com.kodilla.ecommercee;


import com.kodilla.ecommercee.service.UserControllerMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserControllerMethodsService userControllerMethodsService;


    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserById")
    public UserDto getUserById(final Long id)  {
        return new UserDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteById(Long userId) {
        System.out.println("User is deleted.");
    }


    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userControllerMethodsService.createUser(userDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "authorizationUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto authorizationUser(@RequestBody UserDto userDto, @RequestParam String key, @RequestParam String name, @RequestParam String password) {
        return userControllerMethodsService.authorization(userDto, key, name, password);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeKey", consumes = APPLICATION_JSON_VALUE)
    public UserDto changeKey(@RequestBody UserDto userDto, @RequestParam String name, @RequestParam String password) {
        return userControllerMethodsService.changeKey(userDto, name, password);

    }
}