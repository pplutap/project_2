package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String lastName;

    @NotNull
    @Column
    private String address;

    @NotNull
    @Column
    private String login;

    @NotNull
    @Column
    private String password;

    public User(String name, String lastName, String address, String login, String password, Cart cart, List<Order> orders) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.login = login;
        this.password = password;
        this.cart = cart;
        this.orders = orders;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
}

