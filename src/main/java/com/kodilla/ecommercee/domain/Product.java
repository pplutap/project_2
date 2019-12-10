package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //TODO: for discuss
    @JoinTable(
            name = "PRODUCT_TO_CART",
            joinColumns = {@JoinColumn(name = "PRODUCTS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CARTS_ID")}
    )
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

}
