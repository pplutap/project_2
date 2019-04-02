package com.kodilla.ecommercee.Controller;

import com.kodilla.ecommercee.controller.GroupController;
import com.kodilla.ecommercee.dto.GroupDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

public class GroupControllerTest {
    private GroupController groupController = new GroupController();

    @Test
    public void testGetGroups() {
        //given

        //then

        List<GroupDto> groups = groupController.getGroups();

        //then
        Assert.assertEquals(0, groups.size());
    }

    @Test
    public void testGetGroup() {
        //then

        //when
        GroupDto groupDto = groupController.getGroup(1L);
        //then
        Assert.assertEquals(null, groupDto.getDescription());
        Assert.assertEquals(null, groupDto.getName());
        Assert.assertEquals(null, groupDto.getGroupId());

    }


}
