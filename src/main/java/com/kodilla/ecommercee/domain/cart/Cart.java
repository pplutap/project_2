package com.kodilla.ecommercee.domain.cart;

import lombok.*;
import javax.persistence.*;


@Data
@Entity
public class Cart {
    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Product_Name")
    private String product;
}
