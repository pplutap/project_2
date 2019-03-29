package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Entity
public class User {
    @Id
    private Long userId;
    private String userName;
    private String isBlocked;
    private Long userIdKey;
}

