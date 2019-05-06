package com.kodilla.ecommercee.domain;

import java.util.Date;

public class OrderDto {
    private Long id;
    private Date dateCreated;
    private String status;

    public OrderDto() {
    }

    public OrderDto(Long id, String status) {
        this.id = id;
        this.dateCreated = new Date();
        this.status = status;
    }
}
