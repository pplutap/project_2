package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "USER")
//@AllArgsConstructor
@Setter
public class UserOwn {

    public UserOwn(Long id, String login, String password, String uuid, boolean isBlocked, LocalTime beginValidityOfUuid, LocalTime endValidityOfUuid) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.uuid = uuid;
        this.isBlocked = isBlocked;
        this.beginValidityOfUuid = beginValidityOfUuid;
        this.endValidityOfUuid = endValidityOfUuid;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setBeginValidityOfUuid(LocalTime beginValidityOfUuid) {
        this.beginValidityOfUuid = beginValidityOfUuid;
    }

    public void setEndValidityOfUuid(LocalTime endValidityOfUuid) {
        this.endValidityOfUuid = endValidityOfUuid;
    }

}
//jwt token
