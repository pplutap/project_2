package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String street;

    private String houseNumber;

    private String flatNumber;

    private String zipCode;

    private String city;

    private String comments;

    private DeliveryType deliveryType;

    private PaymentType paymentType;

    private BigDecimal totalPrice;

    @OneToOne(
            cascade = CascadeType.ALL, //TODO: for discuss
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CARTS_ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
