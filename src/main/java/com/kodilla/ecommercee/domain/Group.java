package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public class Group {
    private Long id;
    private String name;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
