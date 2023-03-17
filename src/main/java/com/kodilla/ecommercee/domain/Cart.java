package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue
    private Long cartId;

    @ManyToMany(cascade = CascadeType.ALL,
                   fetch = FetchType.EAGER)
    @JoinTable(
            name = "join_carts_products",
            joinColumns = {@JoinColumn(name = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products = new ArrayList<>();

    public Cart(List<Product> products) {
        this.products = products;
    }
}
