package com.kodilla.ecommercee.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Groups")
@Getter
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="groupId",unique = true)
    private Long groupId;

}
