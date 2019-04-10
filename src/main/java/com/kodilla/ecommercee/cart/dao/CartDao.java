package com.kodilla.ecommercee.cart.dao;

import com.kodilla.ecommercee.cart.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CartDao extends CrudRepository<Cart, Long> {
    @Override
    Cart save(Cart cart);

}
