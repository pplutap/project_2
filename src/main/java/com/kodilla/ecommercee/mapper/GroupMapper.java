package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    @Autowired
    ProductMapper productMapper;

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(groupDto.getGroupId(),
                groupDto.getGroupName(),
                productMapper.mapToProductList(groupDto.getProductsList()));
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(
                group.getGroupId(),
                group.getGroupName(),
                productMapper.mapToProductDtoList(group.getProductsList()));
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList) {
        return groupList.stream()
                .map(g -> new GroupDto(g.getGroupId(), g.getGroupName(), productMapper.mapToProductDtoList(g.getProductsList())))
                .collect(Collectors.toList());
    }
}