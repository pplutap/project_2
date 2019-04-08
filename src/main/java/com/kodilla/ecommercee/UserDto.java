package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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


