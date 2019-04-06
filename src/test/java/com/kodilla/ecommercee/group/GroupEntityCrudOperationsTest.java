package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.group.dao.GroupDao;
import com.kodilla.ecommercee.group.domain.Group;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityCrudOperationsTest {

    @Autowired
    private GroupDao groupDao;

    //TODO
    //change GroupDao na ProductDao
    @Autowired
    private GroupDao productDao;

    @Test
    public void createGroupTest() {
        //given
        Group group1 = new Group("group 1","group 1 desc");
        Group group2 = new Group("group 2","group 2 desc");
        Group group3 = new Group("group 3","group 3 desc");

        //when
        int sizeGroupBeforeSave = groupDao.findAll().size();
        groupDao.save(group1);
        groupDao.save(group2);
        groupDao.save(group3);

        //then
        Assert.assertEquals(sizeGroupBeforeSave + 3, groupDao.findAll().size());

        //cleanup
        groupDao.delete(group1);
        groupDao.delete(group2);
        groupDao.delete(group3);
    }

    @Test
    public void readGroupTest() {
        //given
        Group group1 = new Group("group 1","group 1 desc");

        //when
        groupDao.save(group1);
        Long id1 = group1.getIdGroup();
        Group savedGroup = groupDao.findById(id1).get();

        //then
        Assert.assertEquals(savedGroup.getNameOfGroup(), group1.getNameOfGroup());

        //cleanup
        groupDao.delete(group1);
    }

    @Test
    public void readAllGroupTest() {
        //given
        Group group1 = new Group("group 1","group 1 desc");
        Group group2 = new Group("group 2","group 2 desc");
        Group group3 = new Group("group 3","group 3 desc");

        //when
        groupDao.save(group1);
        groupDao.save(group2);
        groupDao.save(group3);
        List<Group> groups = groupDao.findAll();

        //then
        Assert.assertEquals(3, groups.size());

        //cleanup
        groupDao.delete(group1);
        groupDao.delete(group2);
        groupDao.delete(group3);
    }

    @Test
    public void updateGroupTest() {
        //given
        Group group1 = new Group("group 1","group 1 desc");

        //when
        groupDao.save(group1);
        Long id1 = group1.getIdGroup();
        String newNameOfGroup = "renamed group 1";
        group1.setNameOfGroup(newNameOfGroup);
        groupDao.save(group1);

        //then
        Assert.assertEquals(newNameOfGroup, groupDao.findById(id1).get().getNameOfGroup());

        //cleanup
        groupDao.delete(group1);
    }

    @Test
    public void deleteGroupTest() {
        //given
        Group group1 = new Group("group 1","group 1 desc");
        Group group2 = new Group("group 2","group 2 desc");

        //when
        int sizeGroupsBeforeSave = groupDao.findAll().size();
        groupDao.save(group1);
        groupDao.save(group2);
        int sizeGroupsBeforeDelete = groupDao.findAll().size();
        int sizeProductsBeforeDelete = productDao.findAll().size();
        groupDao.delete(group1);
        groupDao.delete(group2);
        int sizeGroupsAfterDelete = groupDao.findAll().size();
        int sizeProductsAfterDelete = productDao.findAll().size();

        //then
        Assert.assertEquals(sizeGroupsBeforeSave + 2, sizeGroupsBeforeDelete);
        Assert.assertEquals(sizeGroupsBeforeSave, sizeGroupsAfterDelete);
        Assert.assertEquals(sizeProductsBeforeDelete, sizeProductsAfterDelete);
    }
}
