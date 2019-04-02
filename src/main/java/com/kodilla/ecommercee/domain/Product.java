package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @ManyToOne
    private Cart cart;

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "name")
    private final String name;
    @Column(name = "price")
    private final Double price;
}
