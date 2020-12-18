package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    private Cart cartId;

    @NotNull
    @Column(name = "VALUE")
    private Double value;

    @NotNull
    @Column(name = "STATUS")
    private String status = "pending";

    @NotNull
    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    @NotNull
    @Column(name = "SHIPPINGADDRESS")
    private String shippingAddress;

    public Order() {

    }

    public Order(@NotNull Long id, User user, Cart cartId, @NotNull Double value, @NotNull String shippingAddress) {
        this.id = id;
        this.user = user;
        this.cartId = cartId;
        this.value = value;
        this.dateTime = LocalDateTime.now();
        this.shippingAddress = shippingAddress;
    }
}
