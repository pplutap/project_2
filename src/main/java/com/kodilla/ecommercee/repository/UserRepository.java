package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
import com.kodilla.ecommercee.domain.User;

import java.util.Optional;

public interface UserRepository extends GenericEntityRepository {
    User save(User user);

    Optional<User> findById(long id);

    void delete(User user);

    default User findOrThrow(long id) throws EntityNotFoundException {
        User user = findById(id).orElseThrow(EntityNotFoundException::new);
        return user;
    }
}