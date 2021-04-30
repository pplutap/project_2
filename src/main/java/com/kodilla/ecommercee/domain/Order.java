package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Order {
    private long orderId;
    private long orderNumber;
    private User user;
    private LocalDate created;
    private Cart cart;
    private OrderStatus status;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID")
    public long getOrderId() {
        return orderId;
    }

    @NotNull
    @Column(name = "ORDER_NUMBER")
    public long getOrderNumber() {
        return orderNumber;
    }

    @NotNull
    @Column(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @NotNull
    @Column(name = "CREATION_DATE")
    public LocalDate getCreated() {
        return created;
    }

    @NotNull
    @Column(name = "CART_ID", unique = true)
    public Cart getCart() {
        return cart;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    public OrderStatus getStatus() {
        return status;
    }

    private void setOrderId(long id) {
        this.orderId = id;
    }

    private void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    private void setUser(User user) {
        this.user = user;
    }

    private void setCreated(LocalDate created) {
        this.created = created;
    }

    private void setCart(Cart cart) {
        this.cart = cart;
    }

    private void setStatus(OrderStatus status) {
        this.status = status;
    }
}
