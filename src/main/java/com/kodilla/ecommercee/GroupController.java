package com.kodilla.ecommercee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    @GetMapping
    public List<GroupDto> getGroups(){
        LOGGER.info("Return all groups");
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public GroupDto getGroup(@PathVariable("id") Long productId) {
        LOGGER.info("Return one group");
        return new GroupDto();
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        LOGGER.info("Updated group");
        return new GroupDto();
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto){
        LOGGER.info("Group is created");
    }
}
