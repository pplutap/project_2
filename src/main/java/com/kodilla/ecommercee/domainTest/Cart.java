package com.kodilla.ecommercee.domainTest;

import com.kodilla.ecommercee.domain.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARTS")

public class Cart {

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @ElementCollection(targetClass = Product.class)
    private List<Product> products = new ArrayList<>();

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProducts() {
        return products;
    }
}