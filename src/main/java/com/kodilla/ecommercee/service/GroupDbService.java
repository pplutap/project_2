package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupDbService {

    private final GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroupById(final Long groupId) {
        return groupRepository.findById(groupId);
    }

    public Group save(final Group group) {
        return groupRepository.save(group);
    }

    public void deleteGroupById(final Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
