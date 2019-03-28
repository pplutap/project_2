package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    private Long cartId;

    @OneToMany(mappedBy = "cart")
    private List<Product> productsList = new ArrayList<>();

    public Cart() {

    }

    public Cart(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }


    public List<Product> getProductsList() {
        return productsList;
    }
}
