package com.kodilla.ecommercee.order.repository;

import com.kodilla.ecommercee.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Override
    List<Order> findAll();
}
