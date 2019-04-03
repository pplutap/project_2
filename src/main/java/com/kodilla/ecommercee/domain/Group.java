package com.kodilla.ecommercee.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "productgroups")
public class Group {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long groupId;

    @Column(name = "groupname")
    private final String groupName;
}