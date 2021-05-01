package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.ProductGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ProductGroupRepository extends CrudRepository<ProductGroup, Long> {
}
