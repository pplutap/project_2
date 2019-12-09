package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
import com.kodilla.ecommercee.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends GenericEntityRepository {
    @Override
    List<Order> findAll();

    Order save(Order order);

    Optional<Order> findById(long id);

    default Order findOrThrow(long id) throws EntityNotFoundException {
        Order order = findById(id).orElseThrow(EntityNotFoundException::new);
        return order;
    }

    void deleteById(Long id);
}
