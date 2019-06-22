package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup (Long groupId){
        return new GroupDto(1L,"Kurtki");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(Long groupId){
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(GroupDto groupDto){
        return new GroupDto(1L, "Jednak plecaki");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(GroupDto groupdDto){
    }
}
