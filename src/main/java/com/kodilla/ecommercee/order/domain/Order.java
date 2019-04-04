package com.kodilla.ecommercee.order.domain;


import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {
    @Id
    private Long orderId;
    private String orderDescription;
    //private List<Product> productList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Long getOrderId() {
        return orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
