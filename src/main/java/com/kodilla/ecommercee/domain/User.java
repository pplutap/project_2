package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "USERS")
@Setter
@RequiredArgsConstructor
public class User {
    private long id;
//    private List<Order> ordersList;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    public long getId() {
        return id;
    }

//    @OneToMany(
//            targetEntity = Order.class,
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    public List<Order> getOrdersList() {
//        return ordersList;
//    }
}
