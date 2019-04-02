package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name = null;

    @Column(name = "price")
    private Double price = null;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cart cart;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
