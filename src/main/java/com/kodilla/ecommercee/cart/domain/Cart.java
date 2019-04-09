package com.kodilla.ecommercee.cart.domain;

import com.kodilla.ecommercee.order.domain.Order;
import com.kodilla.ecommercee.product.domain.Product;
import com.kodilla.ecommercee.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long cartId;

    @ManyToMany
    @JoinTable(
            name = "join_carts_products",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}
    )
    private List<Product> productList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(targetEntity = Order.class, mappedBy = "cart", fetch = FetchType.LAZY)
    private Order order;

}
