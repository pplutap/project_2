package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "GROUPS")
public class Group {

    private Long id;
    private String description;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID",unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
}
