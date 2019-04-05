package com.kodilla.ecommercee.order.domain;


import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.product.domain.Product;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {
    private Long orderId;
    private String orderDescription;
    //private List<Product> productList = new ArrayList<>();
    private Cart cart;

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    @Column(name = "ORDER_DESCRIPTION")
    public String getOrderDescription() {
        return orderDescription;
    }

    @OneToOne
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
