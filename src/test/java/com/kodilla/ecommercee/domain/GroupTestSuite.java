package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GroupTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testGroup() {
        //Given

        Group group = new Group("Name");

        //When
        groupRepository.save(group);

        //Then
        Long id = group.getGroupId();
        Optional<Group> readGroup = groupRepository.findById(id);
        assertTrue(readGroup.isPresent());

        //CleanUp
        groupRepository.deleteById(id);
    }
}