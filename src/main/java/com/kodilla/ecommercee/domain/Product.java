package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PRODUCTS")
public class Product {
    @Id
    private long id;
    private String name;
    private String description;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;
}
