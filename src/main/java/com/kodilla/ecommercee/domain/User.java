package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class User {

    @Id
    private Long id;
}
