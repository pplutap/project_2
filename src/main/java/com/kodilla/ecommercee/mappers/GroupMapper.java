package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {


    @Autowired
    private ProductMapper productMapper;


    public Group mapToGroup(final GroupDto groupDto){
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                productMapper.mapToProductList(groupDto.getProductDtoList()));
    }

    public GroupDto mapToGroupDto(final Group group){
        return new GroupDto(
                group.getId(),
                group.getName(),
                productMapper.mapToProductDtoList(group.getProducts()));
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList){
        return groupList.stream()
                .map(t -> new GroupDto(
                        t.getId(),
                        t.getName(),
                        productMapper.mapToProductDtoList(t.getProducts())))
                .collect(Collectors.toList());
    }
    public List<Group> mapToGroupList(final List<GroupDto> groupDtoList){
        return groupDtoList.stream()
                .map(t -> new Group(
                        t.getId(),
                        t.getName(),
                        productMapper.mapToProductList(t.getProductDtoList())))
                .collect(Collectors.toList());
    }
}
