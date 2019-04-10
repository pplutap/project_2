package com.kodilla.ecommercee.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ORDER")
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
@Getter
public class Order {

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
