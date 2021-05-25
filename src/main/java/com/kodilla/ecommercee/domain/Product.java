package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Product.findByPartOfTheName",
        query = "FROM Product WHERE name LIKE CONCAT('%', :NAME, '%')"
)
@Entity
@Table(name="Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Group groupId;
    private List<Cart> carts = new ArrayList<>();

    public Product(Long id, String name, String description, BigDecimal price, Group groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

    public Product(String name, String description, BigDecimal price, Group groupId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="PRODUCT_ID",unique = true)
    public Long getId() {
        return id;
    }
    @Column(name="NAME")
    public String getName() {
        return name;
    }
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }
    @NotNull
    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
    @ManyToOne
    @JoinColumn(name="GROUP_ID")
    public Group getGroupId() {
        return groupId;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }
}