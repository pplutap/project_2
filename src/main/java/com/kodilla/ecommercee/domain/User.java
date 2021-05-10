package com.kodilla.ecommercee.domain;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Setter
@RequiredArgsConstructor
public class User {

    private long id;
    private String username;
    private boolean status;
    private int userKey;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();

    public User(String username, boolean status) {
        this.username = username;
        this.status = status;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "USER_NAME", unique = true)
    public String getUsername() {
        return username;
    }

    @NotNull
    @Column(name = "USER_STATUS")
    public boolean isStatus() {
        return status;
    }

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    public List<Order> getOrders() {
        return orders;
    }

    @Transient
    public int getUserKey() {
        return userKey;
    }
}
