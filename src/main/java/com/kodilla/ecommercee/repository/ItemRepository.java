package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    @Override
    Optional<Item> findById(Long id);

    @Override
    List<Item> findAll();

    @Override
    Item save(Item item);

    List<Item> findByCart(Cart cart);

    @Override
    void deleteById(Long itemId);
}
