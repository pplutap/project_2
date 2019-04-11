package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CART")
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
@Getter
public class Cart {

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;
}
