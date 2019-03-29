package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long cartId;

    @OneToMany(mappedBy = "cart")
    private List<Product> productsList = new ArrayList<>();

    public Cart(Long cartId) {
        this.cartId = cartId;
    }

}
