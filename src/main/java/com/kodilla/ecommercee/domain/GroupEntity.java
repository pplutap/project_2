package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "group_entity")
public final class GroupEntity {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long idGroup;

    public Long getIdGroup() {
        return idGroup;
    }

    @Column(name = "NAME")
    private String nameOfGroup;

    public String getNameOfGroup() {
        return nameOfGroup;
    }


    @Column(name = "DESCRIPTION")
    private String descriptionOfGroup;

    public String getDescriptionOfGroup() {
        return descriptionOfGroup;
    }

    public GroupEntity() {

    }

    public GroupEntity(String nameOfGroup, String descriptionOfGroup) {
        this.nameOfGroup = nameOfGroup;
        this.descriptionOfGroup = descriptionOfGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public void setDescriptionOfGroup(String descriptionOfGroup) {
        this.descriptionOfGroup = descriptionOfGroup;
    }
}
