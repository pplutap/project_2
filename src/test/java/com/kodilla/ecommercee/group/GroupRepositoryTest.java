package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.group.domain.Group;
import com.kodilla.ecommercee.group.dao.GroupDao;
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
    private GroupDao groupDao;

    @Test
    public void saveGroupRepository() {
        //given
        Group group = new Group("test", "test");

        //when
        groupDao.save(group);

        //then
        Assert.assertNotNull(group.getIdGroup());

        //cleanup
        groupDao.delete(group);
    }

    @Test
    public void testFindAll() {
        //given
        Group group = new Group("test", "test");
        Group group1 = new Group("test1", "test1");
        Group group2 = new Group("test2", "test2");
        groupDao.save(group);
        groupDao.save(group1);
        groupDao.save(group2);

        //when
        List<Group> showGroups = groupDao.findAll();

        //then
        Assert.assertEquals(3, showGroups.size());

        //cleanUp
        groupDao.deleteAll(showGroups);

    }
}