package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String password;
    private boolean isBlocked;

    UserDto() {

    }
}


