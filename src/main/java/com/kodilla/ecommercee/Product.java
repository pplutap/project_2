package com.kodilla.ecommercee;

import lombok.AccessLevel;
import lombok.Setter;
import javax.persistence.*;

@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name="PRODUCTS")
public class Product {

    private Long id;
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="CART_ID")
    public Cart getCart() {
        return cart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
}
