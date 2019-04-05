package com.kodilla.ecommercee.group.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "groups")
public final class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long idGroup;

    @Column(name = "NAME")
    private String nameOfGroup;

    @Column(name = "DESCRIPTION")
    private String descriptionOfGroup;
    public Group(){

    }

    public Group(String nameOfGroup, String descriptionOfGroup) {
        this.nameOfGroup = nameOfGroup;
        this.descriptionOfGroup = descriptionOfGroup;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public String getDescriptionOfGroup() {
        return descriptionOfGroup;
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