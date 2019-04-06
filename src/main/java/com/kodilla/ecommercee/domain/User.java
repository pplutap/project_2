package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
@Getter
public class User {

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRSTNAME")
    @NotNull
    private String firstName;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastName;

    @Column(name = "BIRTHDATE")
    @NotNull
    private LocalDate birthDate;

    @Column(name = "ADRESS")
    private String adress;

    @Column(name = "LOGIN")
    @NotNull
    private String login;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "IS_BLOCKED")
    @NotNull
    private boolean isBlocked;

    @Column(name = "UUID")
    @NotNull
    private String uuid;

    @Column(name = "BEGIN_VALIDITY_UUID")
    @NotNull
    private LocalTime beginValidityOfUuid;

    @Column(name = "END_VALIDITY_UUID")
    @NotNull
    private LocalTime endValidityOfUuid;
}