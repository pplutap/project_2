package com.kodilla.ecommercee.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodilla.ecommercee.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "USERS")
public class User {
    @Id
    private Long userId;
    private String userName;
    private String status;
    private Long userKey;

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Cart getCart() {
        return cart;
    }
}
