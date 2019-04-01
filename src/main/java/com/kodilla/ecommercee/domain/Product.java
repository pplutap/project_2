package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @ManyToOne
    private Cart cart;

    @Id
    @Column(name = "id")
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;
}
