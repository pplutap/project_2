package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "carts")
public class Cart {

    @Id
    private Long id;
}
