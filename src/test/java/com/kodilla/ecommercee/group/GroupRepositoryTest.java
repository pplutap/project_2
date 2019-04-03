package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.group.domain.Group;
import com.kodilla.ecommercee.group.repository.GroupRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupRepositoryTest {
    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void saveGroupRepository() {
        //given
        Group group = new Group("test", "test");

        //when
        groupRepository.save(group);

        //then
        Assert.assertNotNull(group.getIdGroup());

        //cleanup
        groupRepository.deleteAll();

    }

    @Test
    public void testFindAll() {
        //given
        Group group = new Group("test", "test");
        Group group1 = new Group("test", "test");
        Group group2 = new Group("test", "test");

        //when
        List<Group> showGroup = groupRepository.findAll();
        showGroup.add(group);
        showGroup.add(group1);
        showGroup.add(group2);

        //then
        Assert.assertEquals(3, showGroup.size());
        //cleanUp
        groupRepository.deleteAll();

    }
}