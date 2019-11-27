package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/groups")
public class GroupController {

    @GetMapping
    public List<GroupDto> getAllProductGroups() {
        return new ArrayList<GroupDto>();
    }

    @GetMapping("/{groupId}")
    public GroupDto getGroup(@PathVariable(required = true) Long groupId) throws GroupNotFoundException {
        return new GroupDto(1L, "Test group name");
    }

    @PostMapping
    public void add(@RequestBody GroupDto groupDto) {
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return new GroupDto(1L, "Edited test group name");
    }

}
