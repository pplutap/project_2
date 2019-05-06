package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GROUPS")
public class Group {

    private Long id;
    private String description;

    @Id
    @NotNull
    @Column(name = "ID",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
}
