package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Group groupId;
    private List<Cart> carts = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID",unique = true)
    public Long getId() {
        return id;
    }
    @Column(name="NAME")
    public String getName() {
        return name;
    }
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }
    @NotNull
    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name="GROUP_ID")
    public Group getGroupId() {
        return groupId;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Cart> getCarts() {
        return carts;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;

    }
}