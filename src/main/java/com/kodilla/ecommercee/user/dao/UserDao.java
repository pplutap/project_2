package com.kodilla.ecommercee.user.dao;

import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sun.misc.Cache;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    @Override
    User save(User user);

    @Override
    void deleteById(Long userId);

    @Override
    Optional<User> findById(Long userId);

    @Override
    List<User> findAll();

}
