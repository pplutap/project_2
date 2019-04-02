package com.kodilla.ecommercee.Controller;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.repository.GroupRepository;
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
        GroupEntity group = new GroupEntity("test", "test");

        //when
        groupRepository.save(group);
        //then
        Assert.assertEquals(1, 1);

//cleanup
        groupRepository.deleteAll();
    }

    @Test
    public void testFindAll() {
        //given
        GroupEntity group = new GroupEntity("test", "test");
        GroupEntity group1 = new GroupEntity("test", "test");
        GroupEntity group2 = new GroupEntity("test", "test");

        //when
        List<GroupEntity> showGroup = groupRepository.findAll();
        showGroup.add(group);
        showGroup.add(group1);
        showGroup.add(group2);

        //then
        Assert.assertEquals(3, showGroup.size());
        //cleanUp
        groupRepository.deleteAll();

    }
}

