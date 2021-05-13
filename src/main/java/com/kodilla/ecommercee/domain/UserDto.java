package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String role;
    private boolean status;
    private int userKey;
    private long cartId;
    private List<Long> ordersId;
}
