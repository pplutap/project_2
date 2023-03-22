package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_Id")
    @JsonBackReference
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    @JsonBackReference
    private User user;

    private LocalDateTime orderDate;

    public Order(Long orderId, Cart cart, User user) {
        this.orderId = orderId;
        this.cart = cart;
        this.user = user;
        this.orderDate= LocalDateTime.now();
    }
}