package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GroupRepository extends CrudRepository<GroupEntity, Long> {
    @Override
    List<GroupEntity> findAll();

    @Override
     GroupEntity save(GroupEntity group);

}
