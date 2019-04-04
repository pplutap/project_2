package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    @GetMapping
    public List<GroupDto> getGroups(){
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public GroupDto getGroup(@PathVariable("id") Long productId) {
        return new GroupDto();
    }

    @PutMapping()
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return new GroupDto();
    }

    @PostMapping(consumes = "application/json")
    public void createGroup(@RequestBody GroupDto groupDto){
        System.out.println("Group is created");
    }
}
