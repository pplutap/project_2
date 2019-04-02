package com.kodilla.ecommercee.product.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Entity(name = "PRODUCTS")
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long groupId;

}
