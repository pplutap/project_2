package com.kodilla.ecommercee.domain;

public class Product {
    private Long id;
    private String name;
    private double prize;

    public Product() {
    }

    public Product(Long id, String name, double prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrize() {
        return prize;
    }
}
