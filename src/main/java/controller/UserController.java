package controller;

import domain.UserDto;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }


    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public void getUser(@RequestParam Long userId) throws TaskNotFoundException {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteUser(Long userId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public String updateTask(UserDto userDto) {
       return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody UserDto userDto) {


    }
}



