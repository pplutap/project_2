package com.kodilla.ecommercee.dto;

import java.util.List;

public class GroupDto {
    private Long groupId;
    private String name;
    private String description;
   private List<GroupDto> groupDtoList;


    public GroupDto(Long groupId, String name, String description, List<GroupDto> groupDtoList) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.groupDtoList = groupDtoList;
    }

    public GroupDto() {

    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<GroupDto> getGroupDtoList() {
        return groupDtoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupDtoList(List<GroupDto> groupDtoList) {
        this.groupDtoList = groupDtoList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
