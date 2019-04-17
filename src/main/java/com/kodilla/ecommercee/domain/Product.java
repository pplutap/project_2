package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private Group group;

    @OneToMany(mappedBy = "product")
    private List<Item> itemsList = new ArrayList<>();

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}

