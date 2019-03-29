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
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "ISBLOCKED")
    private String isBlocked;

    @Column(name = "USERIDKEY")
    private Long userIdKey;
}

