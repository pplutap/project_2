package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "isblocked")
    private String isBlocked;

    @Column(name = "useridkey")
    private Long userIdKey;
}

