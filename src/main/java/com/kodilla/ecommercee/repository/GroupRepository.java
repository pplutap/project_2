package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;

import java.util.List;
import java.util.Optional;


public interface GroupRepository extends GenericEntityRepository {
    @Override
    List<Group> findAll();

    Optional<Group> findById(long id);

    Group save(Group group);
}
