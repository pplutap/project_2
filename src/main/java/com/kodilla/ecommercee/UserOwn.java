package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserOwn {

    private Long id;
    private String login;
    private String password;
    private String uuid;
    private boolean isBlocked;
    private LocalTime beginValidityOfUuid;
    private LocalTime endValidityOfUuid;

    @Column(name = "ID", unique = true)
    @Id
    @NotNull
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "LOGIN")
    @NotNull
    public String getLogin() {
        return login;
    }

    @Column(name = "PASSWORD")
    @NotNull
    public String getPassword() {
        return password;
    }

    @Column(name = "UUID")
    @NotNull
    public String getUUID() {
        return uuid;
    }

    @Column(name = "ISBLOCKED")
    public boolean getIsBlocked() {
        return isBlocked;
    }

    @Column(name = "BEGINVALIDITYOFUUID")
    public LocalTime getBeginValidityOfUuid() {
        return beginValidityOfUuid;
    }

    @Column(name = "ENDVALIDITYOFUUID")
    public LocalTime getEndValidityOfUuid() {
        return endValidityOfUuid;
    }

}
//jwt token
//czy isBlocked powinno być przypisane do klasy, czy można je zainicjować jako static i implementacja i klasa User
//2. zwracanie sztucznych danych
//4. paczki
//1. rest api a endpointy
//3. operacje na branchach, czy sam pull request tworzymy na stronie, czy rebase trzeba tworzyć po pull request, łączenie commitów, czy fix typo już istnieje