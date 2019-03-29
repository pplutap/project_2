package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Group() {

    }

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String nameOfGroup) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
