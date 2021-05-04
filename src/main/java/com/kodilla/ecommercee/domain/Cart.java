package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CARTS")
@Setter
@RequiredArgsConstructor
public class Cart {

    private long id;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID", unique = true)
    public long getId() {
        return id;
    }
}
