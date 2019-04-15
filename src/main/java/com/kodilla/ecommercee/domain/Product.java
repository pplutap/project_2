package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
@Getter
public final class Product {

    @Column(name = "PRODUCT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name = "CONTENT")
    @NotNull
    private String content;

    @Column(name = "PRICE")
    @NotNull
    private double price;

//    @ManyToOne
//    @JoinColumn(name = "ORDER_ID")
//    @NotNull
//    private Order order;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    @NotNull
    private Cart cart;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "products"
    )
    private List<Group> groups;
}