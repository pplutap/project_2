package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/v1/ecommercee/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup (@RequestParam Long groupId){
        return new GroupDto(1L,"Kurtki");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId){
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return new GroupDto(1L, "Jednak plecaki");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupdDto){
    }
}
