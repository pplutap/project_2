package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "USER")
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String adress;


    @Column(name = "ID", unique = true)
    @Id
    @NotNull
    @GeneratedValue
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRSTNAME")
    @NotNull
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LASTNAME")
    @NotNull
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "BIRTHDATE")
    @NotNull
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "ADRESS")
    public void setAdress(String adress) {
        this.adress = adress;
    }
}
