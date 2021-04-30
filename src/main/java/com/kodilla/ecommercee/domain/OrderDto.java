package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class OrderDto {
    private long id;
    private long orderId;
    private UserDto userDto;
    private LocalDate creationDate;
    private CartDto cartDto;
}
