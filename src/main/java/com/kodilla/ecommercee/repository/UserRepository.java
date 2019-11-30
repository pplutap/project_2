package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long id);

    @Override
    void deleteById(Long id);

    default Optional<User> findOrThrow(Long id) throws EntityNotFoundException{
        Optional<User> user = Optional.ofNullable(findById(id).orElseThrow(() -> new EntityNotFoundException()));
        return user;
    }
}