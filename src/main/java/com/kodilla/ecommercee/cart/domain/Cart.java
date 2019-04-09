package com.kodilla.ecommercee.cart.domain;

import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {
    private Long cartId;
    private List<Product> productList = new ArrayList<>();
    private User user;
    private Order order;

    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    public Long getCartId() {
        return cartId;
    }


    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @OneToOne(targetEntity = Order.class, mappedBy = "cart", fetch = FetchType.LAZY)
    public Order getOrder() {
        return order;
    }

    @ManyToMany
    @JoinTable(
            name = "join_carts_products",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}
    )
    public List<Product> getProductList() {
        return productList;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
