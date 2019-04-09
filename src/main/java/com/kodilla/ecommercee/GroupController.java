package com.kodilla.ecommercee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/groups")
public class GroupController {

    @GetMapping
    public List<GroupDto> getGroups(){
        log.info("Return all groups");
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public GroupDto getGroup(@PathVariable("id") Long productId) {
        log.info("Return one group");
        return new GroupDto();
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        log.info("Updated one group");
        return new GroupDto();
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto){
        log.info("Group is created");
    }
}
