package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;

@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "ORDERS")
public class Order  {

    private Long id;
    private Cart cart;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CART_ID")
    public Cart getCart() {
        return cart;
    }
}