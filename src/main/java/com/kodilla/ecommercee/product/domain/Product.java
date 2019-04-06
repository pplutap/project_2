package com.kodilla.ecommercee.product.domain;

import com.kodilla.ecommercee.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long groupId;
    private Order order;

    @Id
    @Column(name = "product_id")
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "product_name")
    public String getName() {
        return name;
    }

    @NotNull
    @Column(name = "product_description")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "product_price")
    public Double getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "group_id")
    public Long getGroupId() {
        return groupId;
    }

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
