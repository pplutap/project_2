package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/group")
public class GroupController {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupService groupService;

    @GetMapping("getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getGroupsList());
    }

    @GetMapping("getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupService.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @PostMapping(value = "createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.createGroup(groupMapper.mapToGroup(groupDto));
    }

    @PutMapping("updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }
}