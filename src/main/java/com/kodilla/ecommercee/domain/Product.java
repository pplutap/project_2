package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "PRODUCTS")
public class Product {

    private Long id;
    private Cart cart;
    private List<Group> groups;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    public Long getId() {
        return id;
    }

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "products"
    )
    public List<Group> getGroups() {
        return groups;
    }
}
