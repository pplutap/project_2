package com.kodilla.ecommercee.order.domain;


import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "ORDERS")
public class Order {
    @Id
    private Long orderId;
    private String orderDescription;
    //private List<Product> productList = new ArrayList<>();

    public Long getOrderId() {
        return orderId;
    }

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Cart getCart() {
        return cart;
    }
}
