package com.kodilla.ecommercee.domain;

import java.util.Date;

public class Order {
    private Long id;
    private Date dateCreated;
    private String status;

    public Order() {
    }

    public Order(Long id, String status) {
        this.id = id;
        this.dateCreated = new Date();
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }
}
