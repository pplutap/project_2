package com.kodilla.ecommercee.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Order {
    private long id;
    private long orderId;
    private User user;
    private LocalDate creationDate;
    private
}
