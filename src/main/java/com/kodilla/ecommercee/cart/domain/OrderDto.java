package com.kodilla.ecommercee.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderDto {
    private Long orderId;
    private String orderDescription;
    private List<ProductDto> productList;
}
