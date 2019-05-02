package com.kodilla.ecommercee.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long id;
    private LocalDate dateCreated;
    private String status;
    private List<Product> orderProducts = new ArrayList<>();

    public OrderDto() {
    }

    public OrderDto(Long id, LocalDate dateCreated, String status, List<Product> orderProducts) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getOrderProducts() {
        return orderProducts;
    }
}
