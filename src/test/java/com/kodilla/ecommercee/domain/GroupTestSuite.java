package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTestSuite {
    @Autowired
    GroupService groupService;

    @Autowired
    GroupMapper groupMapper;

    @Transactional
    @Test
    public void testGetGroups() {
        //Given
        Group group1 = new Group("Group1");
        groupService.saveGroup(group1);
        Group group2 = new Group("Group2");
        groupService.saveGroup(group2);
        Group group3 = new Group("Group3");
        groupService.saveGroup(group3);

        //When
        List<Group> listGroups = groupService.getGroupsList();

        //Then
        Assert.assertEquals(listGroups.size(), 3);
    }

    @Transactional
    @Test
    public void testGetGroup() {
        //Given
        Group group1 = new Group("Group1");
        groupService.saveGroup(group1);

        //When
        Long idGroup = groupService.findByGroupName("Group1").getGroupId();
        Group receivedGroup = groupService.getGroup(idGroup).get();
        String testGroupName = receivedGroup.getGroupName();

        //Then
        Assert.assertEquals(testGroupName, "Group1");
    }

    @Transactional
    @Test
    public void testCreateGroup() {
        //Given
        List<Group> emptyGroupList = groupService.getGroupsList();
        Group group2 = new Group("Group2");
        groupService.saveGroup(group2);

        //When
        List<Group> groupListWithCreatedGroup = groupService.getGroupsList();

        //Then
        Assert.assertEquals(emptyGroupList.size()+1, groupListWithCreatedGroup.size());
    }

    @Transactional
    @Test
    public void testUpdateGroup() {
        //Given
        Group group3 = new Group("Group3");
        groupService.saveGroup(group3);
        Long idTestedGroup = groupService.findByGroupName("Group3").getGroupId();

        //When
        Group group3Updated = new Group(idTestedGroup, "Group4");
        groupService.saveGroup(group3Updated);
        String groupNameAfterUpdate = groupService.getGroup(idTestedGroup).get().getGroupName();

        //Then
        Assert.assertEquals(groupNameAfterUpdate, "Group4");
        groupService.deleteById(idTestedGroup);
    }

    @Transactional
    @Test
    public void testGroupToGroupDtoMapper() {
        //Given
        Group group = new Group("Group");
        groupService.saveGroup(group);

        //When
        GroupDto groupDto = groupMapper.mapToGroupDto(groupService.getGroup(group.getGroupId()).orElse(null));

        //Then
        Assert.assertEquals(group.getGroupId(), groupDto.getGroupId());
        Assert.assertEquals(group.getGroupName(), groupDto.getGroupName());
    }

    @Transactional
    @Test
    public void testGroupDtoToGroupMapper() {
        //Given
        GroupDto groupDto = new GroupDto(1L, "Group");

        //When
        Group group = groupMapper.mapToGroup(groupDto);

        //Then
        Assert.assertEquals(groupDto.getGroupId(),group.getGroupId());
        Assert.assertEquals(groupDto.getGroupName(),group.getGroupName());
    }

    @Transactional
    @Test
    public void testGroupListToGroupDtoListMapper() {
        //Given
        Group group = new Group("Group");
        Group group2 = new Group("Group2");
        Group group3 = new Group("Group3");
        Group group4 = new Group("Group4");

        List<Group> groups = new ArrayList<>();
        groups.add(group);
        groups.add(group2);
        groups.add(group3);
        groups.add(group4);

        groupService.saveGroup(group);
        groupService.saveGroup(group2);
        groupService.saveGroup(group3);
        groupService.saveGroup(group4);

        //When
        List<GroupDto> groupDtoRead = groupMapper.mapToGroupDtoList(groupService.getGroupsList());

        //Then
        for (int i = 0; i < groups.size(); i++) {
            Assert.assertEquals(groups.get(i).getGroupId(), groupDtoRead.get(i).getGroupId());
            Assert.assertEquals(groups.get(i).getGroupName(), groupDtoRead.get(i).getGroupName());
        }
    }

}