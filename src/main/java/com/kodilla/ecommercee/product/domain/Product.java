package com.kodilla.ecommercee.product.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long groupId;
    private List<Cart> cartList = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    public Long getId() {
        return id;
    }

    @Column(name = "product_name")
    public String getName() {
        return name;
    }

    @Column(name = "product_description")
    public String getDescription() {
        return description;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    @Column(name = "group_id")
    public Long getGroupId() {
        return groupId;
    }

    @ManyToMany(mappedBy = "productList")
    public List<Cart> getCartList() {
        return cartList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
