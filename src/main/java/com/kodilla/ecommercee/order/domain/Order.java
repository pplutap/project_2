package com.kodilla.ecommercee.order.domain;


import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.product.domain.Product;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    private Long orderId;
    private String orderDescription;
    //private List<Product> productList = new ArrayList<>();
    private Cart cart;

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    @Column(name = "order_description")
    public String getOrderDescription() {
        return orderDescription;
    }

    @OneToOne
    @JoinColumn(name = "cart_id")
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
