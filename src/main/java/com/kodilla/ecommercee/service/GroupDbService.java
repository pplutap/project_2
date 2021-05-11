package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupDbService {
    @Autowired
    private final GroupRepository groupRepository;

    public Optional<Group> getGroupById(final Long id){
        return groupRepository.findById(id);
    }
}
