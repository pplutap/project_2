package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;

@Setter(AccessLevel.PRIVATE)
@Getter                                                                                                                                                                                                                                           @AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    public Order(Cart cart, User user) {
        this.cart = cart;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
}
