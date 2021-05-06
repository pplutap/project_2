package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class OrderDto {
    private final long orderId;
    private final LocalDate created;
    private final OrderStatus status;
    private final long userId;
    private final long cartId;
}
