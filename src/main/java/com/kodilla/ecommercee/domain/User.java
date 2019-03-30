package com.kodilla.ecommercee.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    public User(String userName, Boolean isBlocked, Long userIdKey) {
        this.userName = userName;
        this.isBlocked = isBlocked;
        this.userIdKey = userIdKey;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "isblocked")
    private Boolean isBlocked;

    @Column(name = "useridkey")
    private Long userIdKey;
}

