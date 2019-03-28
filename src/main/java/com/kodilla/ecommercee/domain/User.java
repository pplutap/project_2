package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private String isBlocked;
    private Long userIdKey;
}

