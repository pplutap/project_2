package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends GenericEntityRepository {
    @Override
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(long id);

    default Product findOrThrow(long id) throws EntityNotFoundException {
        Product product = findById(id).orElseThrow(EntityNotFoundException::new);
        return product;
    }

    void deleteById(long id);
}