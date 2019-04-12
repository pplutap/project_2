package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name="CARTS")
public class Cart   {

    private Long id;
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    @OneToMany( targetEntity = Product.class,
                mappedBy = "cart",
                fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
}