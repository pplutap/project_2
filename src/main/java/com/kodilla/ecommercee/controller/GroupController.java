package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value="getGroups")
    public List<GroupDto> getGroups(){
        List<GroupDto> testListOfGoups = new ArrayList<>();
        testListOfGoups.add(new GroupDto(1L,"T-shirts", "Spring/Summer Collection"));
        testListOfGoups.add(new GroupDto(2L,"Shirts", "Autumn/Winter Collection"));
        return testListOfGoups;
    }

    @RequestMapping(method = RequestMethod.POST, value="createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto){
    }

    @RequestMapping(method = RequestMethod.GET, value="getGroup")
    public GroupDto getGroup(@RequestParam Long id) throws GroupNotFoundException{
        return new GroupDto(1L,"T-shirts","Spring/Summer collection");
    }

    @RequestMapping(method = RequestMethod.PUT, value="updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return new GroupDto(1L,"White T-shirts", "Autumn/Winter collection");
    }
}
