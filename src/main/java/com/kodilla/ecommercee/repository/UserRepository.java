package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.UserOwn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends CrudRepository<UserOwn, Long> {
    @Override
    List<UserOwn> findAll();

    @Override
    UserOwn save(UserOwn user);

    @Override
    Optional<UserOwn> findById(Long id);



    void delete(long id);
}
