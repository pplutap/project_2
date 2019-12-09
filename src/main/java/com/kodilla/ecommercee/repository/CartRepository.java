package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.EntityNotFoundException;


import java.util.List;
import java.util.Optional;

public interface CartRepository extends GenericEntityRepository{
    @Override
    List<Cart> findAll();

    Optional<Cart> findById(long id);

    Cart save(Cart cart);

    default Cart findOrThrow(long id) throws EntityNotFoundException {
        Cart cart = findById(id).orElseThrow(EntityNotFoundException::new);
        return cart;
    }

    void deleteById(long id);
}
