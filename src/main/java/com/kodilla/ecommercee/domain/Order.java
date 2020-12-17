package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    @Getter
    private Long id;
    @Getter
    private Double value;
}
