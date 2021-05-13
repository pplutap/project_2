package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NamedNativeQuery(
        name = "Order.retrieveOrdersBelongToUser",
        query = "SELECT * FROM ORDERS WHERE user_id = :USER_ID",
        resultClass = Order.class
)

@Entity
@Table(name = "ORDERS")
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
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
    public Long getOrderId() {
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