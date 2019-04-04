package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroupsList() {
        return groupRepository.findAll();
    }

    public void createGroup(Group group) {
        groupRepository.save(group);
    }

    public Optional<Group> getGroup(Long groupId) {
        return groupRepository.findById(groupId);
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);
    }

    public void deleteById(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    public Group findByGroupName(String groupName) {
        return groupRepository.findByGroupName(groupName).orElse(new Group("Empty Group Name"));
    }

}