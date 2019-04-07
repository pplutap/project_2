package com.kodilla.ecommercee.product.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long groupId;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "productList")
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "productList")
    private List<Cart> carts = new ArrayList<>();
}
