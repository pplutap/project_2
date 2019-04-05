package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String adress;
    private String login;
    private String password;
    private boolean isBlocked;
    private String uuid;
    private LocalTime beginValidityOfUuid;
    private LocalTime endValidityOfUuid;

}


