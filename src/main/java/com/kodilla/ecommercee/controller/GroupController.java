package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/group")
public class GroupController {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupService groupService;

    @GetMapping("getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @GetMapping("getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) {
        return new GroupDto(1L, "group1");
    }

    @PostMapping("createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.createGroup(groupMapper.mapToGroup(groupDto));
    }

    @PutMapping("updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto, @RequestParam Long groupId) {
        return new GroupDto(1L, "updatedGroup1");
    }
}