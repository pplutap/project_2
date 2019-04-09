package com.kodilla.ecommercee;


import com.kodilla.ecommercee.service.UserControllerMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserControllerMethodsService userControllerMethodsService;


   @GetMapping
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }
    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable("id") Long userId)  {
        return new UserDto();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long userId) {
        System.out.println("User is deleted.");
    }


    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userControllerMethodsService.createUser(userDto);
    }

    @PutMapping
    public UserDto authorizationUser(@RequestBody UserDto userDto, @RequestParam String key, @RequestParam String name, @RequestParam String password) {
        return userControllerMethodsService.authorization(userDto, key, name, password);
    }
}
