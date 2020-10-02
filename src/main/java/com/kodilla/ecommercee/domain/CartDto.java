package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;

import java.util.List;

public class CartDto {
    private Long id;
    private Long ownerId;
    private List<GenericEntity> productsList;

    public CartDto(Long id, Long ownerId, List<GenericEntity> productsList) {
        this.id = id;
        this.ownerId = ownerId;
        this.productsList = productsList;
    }

    public Long getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public List<GenericEntity> getProductsList() {
        return productsList;
    }
}
