package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domainTest.Cart;
import com.kodilla.ecommercee.domainTest.Group;
import com.kodilla.ecommercee.domainTest.Order;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
@Getter
public final class Product {

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;


    @Column(name = "PRICE")
    @NotNull
    private double price;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    @NotNull
    private Group group;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @NotNull
    private Order order;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    @NotNull
    private Cart cart;
}
