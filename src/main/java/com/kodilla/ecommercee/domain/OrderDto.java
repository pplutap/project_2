package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class OrderDto {
    private final Long orderId;
    private final LocalDate orderCreated;
    private final OrderStatus status;
    private final long userId;
    private final long cartId;
}
