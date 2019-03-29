package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id",unique = true)
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "isblocked")
    private String isBlocked;

    @Column(name = "useridkey")
    private Long userIdKey;
}

