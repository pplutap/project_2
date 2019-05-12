package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CartDao extends CrudRepository<Cart,Long> {

    @Override
    Cart save (Cart cart);

    @Override
    void deleteById(Long Id);

    @Override
    Optional<Cart> findById(Long Id);
}

