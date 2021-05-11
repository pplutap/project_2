package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/groups")
public class GroupController {

    private final GroupMapper groupMapper;
    private final GroupDbService groupDbService;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupDbService.getAllGroups());
    }

    @GetMapping("getGroup")
    public GroupDto getGroup(@RequestBody Long groupId ) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupDbService.getGroupById(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @PostMapping(value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupDbService.save(groupMapper.mapToGroup(groupDto));
    }


    @PutMapping(value = "updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        Group groupUpdated = groupMapper.mapToGroup(groupDto);
        Group saveGroup = groupDbService.save(groupUpdated);
        return groupMapper.mapToGroupDto(saveGroup);
    }
}
