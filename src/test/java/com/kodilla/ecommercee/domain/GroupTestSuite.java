package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
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
        Group receivedGroup = groupService.getGroup(idGroup);
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
        Assert.assertEquals(emptyGroupList.size() + 1, groupListWithCreatedGroup.size());
    }

    @Transactional
    @Test
    public void testUpdateGroup() {
        //Given
        Group group3 = new Group("Group3");
        groupService.saveGroup(group3);
        Long idTestedGroup = groupService.findByGroupName("Group3").getGroupId();

        //When
        Group group3Updated = new Group(idTestedGroup, "Group4", null);
        groupService.saveGroup(group3Updated);
        String groupNameAfterUpdate = groupService.getGroup(idTestedGroup).getGroupName();

        //Then
        Assert.assertEquals(groupNameAfterUpdate, "Group4");
        groupService.deleteById(idTestedGroup);
    }

    @Transactional
    @Test
    public void testCreateGroupWithProduct() {
        //Given
        Group group5 = new Group("Group5");
        Product product5 = new Product("Laptop", 2500.0);
        group5.getProductsList().add(product5);
        product5.setGroup(group5);
        groupService.saveGroup(group5);

        //When
        Long idGroup = groupService.findByGroupName("Group5").getGroupId();
        Product receivedProduct = groupService.getGroup(idGroup).getProductsList().get(0);

        //Then
        Assert.assertEquals(product5, receivedProduct);
    }

    @Transactional
    @Test
    public void testMapToGroup() {

        //Given
        List<Long> itemId = new ArrayList<>();
        itemId.add(1L);

        ProductDto productDto1 = new ProductDto(1L, "laptop", 10.0, 1L, itemId);
        ProductDto productDto2 = new ProductDto(1L, "apple", 10.0, 1L, itemId);
        ProductDto productDto3 = new ProductDto(1L, "hamster", 10.0, 1L, itemId);

        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(productDto1);
        productDtoList.add(productDto2);
        productDtoList.add(productDto3);
        GroupDto groupDto = new GroupDto(1L, "Group1", productDtoList);

        //When
        Group group = groupMapper.mapToGroup(groupDto);

        //Then
        Assert.assertEquals("hamster", group.getProductsList().get(2).getName());
    }


    @Transactional
    @Test
    public void testMapToGroupDto() {
        //Given
        Product product1 = new Product("ham", 10.0);
        Product product2 = new Product("apple", 5.0);
        Product product3 = new Product("pear", 3.0);

        Group group = new Group("Group1");
        group.getProductsList().add(product1);
        group.getProductsList().add(product2);
        group.getProductsList().add(product3);

        //When
        GroupDto groupDto = groupMapper.mapToGroupDto(group);

        //Then
        Assert.assertEquals("ham", groupDto.getProductsList().get(0).getName());
    }

    @Transactional
    @Test
    public void testMapToGroupDtoList() {
        //Given
        Group group1 = new Group("Group1");
        Product product1 = new Product("ham", 10.0);
        Product product2 = new Product("apple", 5.0);
        Product product3 = new Product("pear", 3.0);
        group1.getProductsList().add(product1);
        group1.getProductsList().add(product2);
        group1.getProductsList().add(product3);

        Group group2 = new Group("Group2");
        Product product4 = new Product("laptop", 15.0);
        Product product5 = new Product("plate", 25.0);
        Product product6 = new Product("book", 5.0);

        group2.getProductsList().add(product4);
        group2.getProductsList().add(product5);
        group2.getProductsList().add(product6);

        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);

        //When
        List<GroupDto> groupDtoList = groupMapper.mapToGroupDtoList(groups);

        //Then
        Assert.assertEquals(2, groupDtoList.size());
        Assert.assertEquals(3, groupDtoList.get(0).getProductsList().size());
    }

}