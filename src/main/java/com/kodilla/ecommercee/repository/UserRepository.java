package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domainTest.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long id);


    @Override
    void deleteById(Long id);
}
