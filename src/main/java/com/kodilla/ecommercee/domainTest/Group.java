package com.kodilla.ecommercee.domainTest;

import com.kodilla.ecommercee.domain.Product;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "GROUPS")
public class Group {


    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;


    @Column
    @ElementCollection(targetClass = Product.class)
    private List<Product> products = new ArrayList<>();

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    public List<Product> getProducts() {
        return products;
    }
}

