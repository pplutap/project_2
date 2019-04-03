package com.kodilla.ecommercee.order.domain;

import com.kodilla.ecommercee.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    private Long orderId;
    private String orderDescription;
    private List<Product> productList;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    private void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "ORDERS_DESCRIPTION")
    public String getOrderDescription() {
        return orderDescription;
    }

    private void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    @Column(name = "PRODUCT_LISTS")
    public List<Product> getProductList() {
        return productList;
    }

    private void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
