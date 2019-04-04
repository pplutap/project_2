package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
//@AllArgsConstructor

public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String uuid;
    private boolean isBlocked;
    private LocalTime beginValidityOfUuid;
    private LocalTime endValidityOfUuid;

    public UserDto(Long id, String login, String password, String uuid, boolean isBlocked, LocalTime beginValidityOfUuid, LocalTime endValidityOfUuid) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.uuid = uuid;
        this.isBlocked = isBlocked;
        this.beginValidityOfUuid = beginValidityOfUuid;
        this.endValidityOfUuid = endValidityOfUuid;
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUuid() {
        return uuid;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public LocalTime getBeginValidityOfUuid() {
        return beginValidityOfUuid;
    }

    public LocalTime getEndValidityOfUuid() {
        return endValidityOfUuid;
    }
}


