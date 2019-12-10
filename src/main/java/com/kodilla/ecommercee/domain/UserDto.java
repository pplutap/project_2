package com.kodilla.ecommercee.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private Long id;
    private boolean isBlocked;
}