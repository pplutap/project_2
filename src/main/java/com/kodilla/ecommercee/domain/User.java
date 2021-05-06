package com.kodilla.ecommercee.domain;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
@Setter
@RequiredArgsConstructor
public class User {
    private Long id;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    public Long getId() {
        return id;
    }
}
