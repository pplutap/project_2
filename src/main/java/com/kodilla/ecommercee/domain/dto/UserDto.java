package com.kodilla.ecommercee.domain.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private Long userId;
    private String userName;
    private Boolean isBlocked;
    private Long userIdKey;

    public UserDto(String userName, Boolean isBlocked, Long userIdKey) {
        this.userName = userName;
        this.isBlocked = isBlocked;
        this.userIdKey = userIdKey;
    }
}