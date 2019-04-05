package com.kodilla.ecommercee.product.domain;

import com.kodilla.ecommercee.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    @Column(name = "PRODUCT_ID")
    public Long getId() {
        return id;
    }

    @Column(name = "PRODUCT_NAME")
    public String getName() {
        return name;
    }

    @Column(name = "PRODUCT_DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "PRODUCT_PRICE")
    public Double getPrice() {
        return price;
    }

    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
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
