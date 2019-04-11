package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
@Getter
public class Order {

    @Column(name = "ID")
    @NotNull
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "USER_ID")
    private User user;
}
