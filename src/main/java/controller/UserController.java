package controller;

import domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/task")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser() {
        System.out.println("The user has been created");;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBlockUser")
    public void getBlockUser(@RequestParam Long Id) throws UserNotFoundException {
        UserDto testingUserDto = new UserDto(1L, "user1", "userDescription");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserToken")
    public UserDto getUserToken(@RequestParam final Long id) throws UserNotFoundException {
        UserDto testingUserDto = new UserDto(1L, "user1", "userDescription");
        return testingUserDto;
    }
}



