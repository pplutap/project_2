package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {
    @GetMapping
    public List<GroupDto> getGroups(){
        System.out.println("Return all groups");
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public GroupDto getGroup(@PathVariable("id") Long productId) {
        System.out.println("Return one group");
        return new GroupDto();
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        System.out.println();
        return new GroupDto();
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto){
        System.out.println("Group is created");
    }
}
