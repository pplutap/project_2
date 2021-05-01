package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "GROUP_ID")
    private ProductGroup productGroup;

    public Product(String productName, String description, BigDecimal price, ProductGroup productGroup) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productGroup = productGroup;
    }
}

