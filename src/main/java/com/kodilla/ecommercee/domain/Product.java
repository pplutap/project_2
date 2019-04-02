package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cart cart;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
