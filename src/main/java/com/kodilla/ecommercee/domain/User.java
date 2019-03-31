package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

    @Column(name = "username")
    private final String userName;
    @Column(name = "isblocked")
    private final Boolean isBlocked;
    @Column(name = "useridkey")
    private final Long userIdKey;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;
}

