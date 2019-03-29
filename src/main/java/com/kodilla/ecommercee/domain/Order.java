package com.kodilla.ecommercee.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Long id;
    private Product product;
    private int quantity;
}
