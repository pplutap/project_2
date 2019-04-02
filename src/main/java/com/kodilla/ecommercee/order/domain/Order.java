package com.kodilla.ecommercee.order.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "ORDERS")
public class Order {
    @Id
    private Long orderId;

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Cart getCart() {
        return cart;
    }
}
