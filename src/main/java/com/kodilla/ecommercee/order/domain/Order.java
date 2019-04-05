package com.kodilla.ecommercee.order.domain;

import com.kodilla.ecommercee.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    private Long orderId;
    private String orderDescription;
    private List<Product> productList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    @Column(name = "ORDER_DESCRIPTION")
    public String getOrderDescription() {
        return orderDescription;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @Column(name = "PRODUCTS_LIST")
    public List<Product> getProductList() {
        return productList;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}