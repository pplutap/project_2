package com.kodilla.ecommercee;

import javax.persistence.*;

@Entity
@Table(name="PRODUCTS")
public class Product {

    private Cart cart;
    private long id;

    @ManyToOne
    @JoinColumn(name="CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
