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
@Table(name = "CARTS")
public class Cart {
    private Long cartId;
    private List<Product> productList = new ArrayList<>();
    private User user;
    private Order order;

    @Id
    @GeneratedValue
    @Column(name = "CART_ID")
    public Long getCartId() {
        return cartId;
    }

    @Transient
    @Column(name = "PRODUCTS_LIST")
    @ElementCollection
    public List<String> getProducts() {
        return productList.stream()
                .map(product -> product.getName())
                .collect(Collectors.toList());
    }

    @Column(name = "USER")
    public String getUsername() {
        return user.getUserName();
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @OneToOne(targetEntity = Order.class, mappedBy = "cart")
    public Order getOrder() {
        return order;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setProductList(Product product) {
        productList.add(product);
    }

    public void setUsername(User user) {
        this.user = user;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
