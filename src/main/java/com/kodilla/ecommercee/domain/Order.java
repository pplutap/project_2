package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "ORDERS")
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    private long orderId;
    private LocalDate orderCreated;
    private OrderStatus status;
    private User user;
    private Cart cart;

    public Order(LocalDate orderCreated, OrderStatus status, User user, Cart cart) {
        this.orderCreated = orderCreated;
        this.status = status;
        this.user = user;
        this.cart = cart;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    public long getOrderId() {
        return orderId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @NotNull
    @Column(name = "CREATION_DATE")
    public LocalDate getOrderCreated() {
        return orderCreated;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    public OrderStatus getStatus() {
        return status;
    }
}
