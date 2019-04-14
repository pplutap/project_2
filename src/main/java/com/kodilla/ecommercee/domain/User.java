package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Entity
@ToString
@Table(name = "users")
public class User {

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

    public User() {
    }

    public User(String userName, Boolean isBlocked, Long userIdKey) {
        this.userName = userName;
        this.isBlocked = isBlocked;
        this.userIdKey = userIdKey;
    }

}

