package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value="getGroups")
    public List<String> getGroups(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value="createGroup")
    public void createGroup(){
    }

    @RequestMapping(method = RequestMethod.GET, value="getGroup")
    public String getGroup(){
        return "T-shirts";
    }

    @RequestMapping(method = RequestMethod.PUT, value="updateGroup")
    public String updateGroup(){
        return "T-shirt blue";
    }
}
