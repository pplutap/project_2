package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("v1/groups")
public class GroupController {

        @GetMapping(value = "getGroups")
        public List<GroupDto> getGroups() {
            return new ArrayList<>();
        }

        @PostMapping(value = "createGroup")
        public void createGroup(@RequestBody GroupDto groupDto) {
        }

        @GetMapping("/{groupId}")
        public GroupDto getGroup(@RequestBody GroupDto groupDto ) {
            return new GroupDto(100L, "First Group");
        }

        @PutMapping(value = "updateGroup")
        public GroupDto updateGroup( GroupDto groupDto) {
            return new GroupDto(100L, "Test content");
        }
}
