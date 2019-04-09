package com.kodilla.ecommercee.group.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "products_groups")
public final class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long idGroup;

    @Column(name = "group_name")
    private String nameOfGroup;

    @Column(name = "group_description")
    private String descriptionOfGroup;

}