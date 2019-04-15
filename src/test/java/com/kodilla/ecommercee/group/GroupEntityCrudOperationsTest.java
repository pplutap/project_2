package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.group.repository.GroupRepository;
import com.kodilla.ecommercee.group.domain.Group;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.product.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityCrudOperationsTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createGroupTest() {
        //given
        List<Product> test = new ArrayList<>();
        Group group1 = new Group(1L,"TEST","test",test);
        Group group2 = new Group(3L,"TEST","test",test);
        Group group3 = new Group(3L,"TEST","test",test);

        //when
        int sizeGroupBeforeSave = groupRepository.findAll().size();
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);

        //then
        Assert.assertEquals(sizeGroupBeforeSave + 3, groupRepository.findAll().size());

        //cleanup
        groupRepository.delete(group1);
        groupRepository.delete(group2);
        groupRepository.delete(group3);
    }
    @Test
    public void readGroupTest() {
        //given
        List<Product> test = new ArrayList<>();
        Group group1 = new Group(null,"test","test",test);

        //when
        groupRepository.save(group1);
        Long id1 = group1.getIdGroup();
        Group savedGroup = groupRepository.findById(id1).get();

        //then
        Assert.assertEquals(savedGroup.getNameOfGroup(), group1.getNameOfGroup());

        //cleanup
        groupRepository.delete(group1);
    }


    @Test
    public void readAllGroupTest() {
        //given
        List<Product> test = new ArrayList<>();
        Group group1 = new Group(1L,"TEST","test",test);
        Group group2 = new Group(3L,"TEST","test",test);
        Group group3 = new Group(3L,"TEST","test",test);

        //when
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        List<Group> groups = groupRepository.findAll();

        //then
        Assert.assertEquals(3, groups.size());

        //cleanup
        groupRepository.delete(group1);
        groupRepository.delete(group2);
        groupRepository.delete(group3);
    }

    @Test
    public void updateGroupTest() {
        //given
        List<Product> test = new ArrayList<>();
        Group group1 = new Group(null,"TEST","test",test);

        //when
        groupRepository.save(group1);
        Long id1 = group1.getIdGroup();
        String newNameOfGroup = "renamed group 1";
        group1.setNameOfGroup(newNameOfGroup);
        groupRepository.save(group1);

        //then
        Assert.assertEquals(newNameOfGroup, groupRepository.findById(id1).get().getNameOfGroup());

        //cleanup
        groupRepository.delete(group1);
    }

    @Test
    public void deleteGroupTest() {
        //given
        List<Product> test = new ArrayList<>();
        Group group1 = new Group(null,"TEST","test",test);
        Group group2 = new Group(null,"TEST","test",test);
        Long idGroup1 = group1.getIdGroup();
        Product product1 = new Product("product 1", "product 1 desc", 100.00, idGroup1);
        Long idGroup2 = group2.getIdGroup();
        Product product2 = new Product("product 2", "product 2 desc", 200.00, idGroup2);

        //when
        int sizeGroupsBeforeSave = groupRepository.findAll().size();
        groupRepository.save(group1);
        groupRepository.save(group2);
        int sizeGroupsBeforeDelete = groupRepository.findAll().size();
        productRepository.save(product1);
        productRepository.save(product2);
        int sizeProductsBeforeDeleteGroups = productRepository.findAll().size();
        groupRepository.delete(group1);
        groupRepository.delete(group2);
        int sizeGroupsAfterDelete = groupRepository.findAll().size();
        int sizeProductsAfterDeleteGroups = productRepository.findAll().size();

        //then
        Assert.assertEquals(sizeGroupsBeforeSave + 2, sizeGroupsBeforeDelete);
        Assert.assertEquals(sizeGroupsBeforeSave, sizeGroupsAfterDelete);
        Assert.assertEquals(sizeProductsBeforeDeleteGroups, sizeProductsAfterDeleteGroups);

        //cleanup
        productRepository.delete(product1);
        productRepository.delete(product2);
    }

}
