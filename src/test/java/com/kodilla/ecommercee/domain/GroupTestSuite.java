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
        Assert.assertEquals(3, listGroups.size());
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
        Assert.assertEquals("Group1", testGroupName);
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
        Assert.assertEquals("Group4", groupNameAfterUpdate);
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
        List<Long> itemsIdList = new ArrayList<>();
        ProductDto productDto1 = new ProductDto(1L, "laptop", 10.0, 1L, itemsIdList);
        ProductDto productDto2 = new ProductDto(1L, "apple", 10.0, 1L, itemsIdList);
        ProductDto productDto3 = new ProductDto(1L, "hamster", 10.0, 1L, itemsIdList);

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
        Group group = new Group("Group1");
        List<Item> itemList = new ArrayList<>();
        Product product1 = new Product(1L, "ham", 10.0, group, itemList);
        Product product2 = new Product(2L, "apple", 5.0, group, itemList);
        Product product3 = new Product(3L, "pear", 3.0, group, itemList);
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
        List<Item> itemList1 = new ArrayList<>();
        Product product1 = new Product(1L, "ham", 10.0, group1, itemList1);
        Product product2 = new Product(2L, "apple", 5.0, group1, itemList1);
        Product product3 = new Product(3L, "pear", 3.0, group1, itemList1);
        group1.getProductsList().add(product1);
        group1.getProductsList().add(product2);
        group1.getProductsList().add(product3);

        Group group2 = new Group("Group2");
        List<Item> itemList2 = new ArrayList<>();
        Product product4 = new Product(1L, "laptop", 15.0, group2, itemList2);
        Product product5 = new Product(2L, "plate", 25.0, group2, itemList2);
        Product product6 = new Product(3L, "book", 5.0, group2, itemList2);
        group2.getProductsList().add(product4);
        group2.getProductsList().add(product5);
        group2.getProductsList().add(product6);

        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);

        //When
        List<GroupDto> groupDtoList = groupMapper.mapToGroupDtoList(groups);

        //Then
        Assert.assertEquals(groups.size(), groupDtoList.size());
        Assert.assertEquals(groups.get(0).getProductsList().size(), groupDtoList.get(0).getProductsList().size());
    }
}