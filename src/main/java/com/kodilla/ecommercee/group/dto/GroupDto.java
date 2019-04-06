package com.kodilla.ecommercee.group.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GroupDto {
    private Long groupId;
    private String name;
    private String description;
    private List<GroupDto> groupDtoList;

}