package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "ORDERS")
@Setter
@RequiredArgsConstructor
public class Order {
    private long orderId;
    private long orderNumber;
    private LocalDate created;
    private OrderStatus status;
    private User user;
    private Cart cart;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    public long getOrderId() {
        return orderId;
    }

    @NotNull
    @Column(name = "ORDER_NUMBER")
    public long getOrderNumber() {
        return orderNumber;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @NotNull
    @Column(name = "CREATION_DATE")
    public LocalDate getCreated() {
        return created;
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
