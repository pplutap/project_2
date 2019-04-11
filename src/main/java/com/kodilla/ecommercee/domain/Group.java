package com.kodilla.ecommercee.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "productgroups")
public class Group {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long groupId;

    @Column(name = "groupname")
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }
}