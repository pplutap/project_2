package com.kodilla.ecommercee.cart.repository;

import com.kodilla.ecommercee.cart.domain.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {
    @Override
    Cart save(Cart cart);

    Optional<Cart> findByCartId(Long cartId);
}
