package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GropuTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    private Group group1;
    private Group group2;
    private Product product1;
    private Product product2;
    private void dataForTests(){

         group1 = new Group(0,"group1",new ArrayList<>());
         group2 = new Group(0,"group2",new ArrayList<>());
         product1 = new Product(0,"product1",12.2,5,null);
         product2 = new Product(0,"product2",122.2,7,null);
    }

    private void deleteTestData() {
        groupRepository.delete(group2);
        groupRepository.delete(group1);
    }

    @Test
    public void testShouldSaveGroup(){

        //Given
        dataForTests();
        //When
        Group savedGroup1 = groupRepository.save(group1);
        Group savedGroup2 = groupRepository.save(group2);

        //Then
        assertThat(savedGroup1.getName()).isEqualTo("group1");
        assertThat(savedGroup1.getGroupId()).isEqualTo(1L);
        assertThat(savedGroup2.getName()).isEqualTo("group2");
        assertThat(savedGroup2.getGroupId()).isEqualTo(2L);

        //CleanUp
        deleteTestData();
    }

    @Test
    public void testUpdateGroups(){

        //Given
        dataForTests();

        //When
        Group saveGroup1 = groupRepository.save(group1);
        saveGroup1.getProducts().add(product1);
        saveGroup1.getProducts().add(product2);
        Group saveGroup2 = groupRepository.save(group2);
        saveGroup2.setName("group2AfterChange");

        //Then
        assertEquals("group1", saveGroup1.getName());
        assertEquals("group2AfterChange", saveGroup2.getName());
        assertEquals(2, saveGroup1.getProducts().size());

        //CleanUp
        deleteTestData();
    }

    @Test
    public void testDeleteGroupById(){

        //Given
        dataForTests();

        //When
       groupRepository.save(group1);
       groupRepository.save(group2);
       groupRepository.deleteById(1L);
       Optional<Group> deletedGroup1 = groupRepository.findById(1L);
       Optional<Group> Group2 = groupRepository.findById(2L);

        //Then
        assertFalse(deletedGroup1.isPresent());
        assertTrue(Group2.isPresent());
    }

    @Test
    public void testFindGroupById(){

        //Given
        dataForTests();

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        Optional<Group> findById = groupRepository.findById(1L);

        //Then
        assertTrue(findById.isPresent());

        //CleanUp
        deleteTestData();
    }



}
