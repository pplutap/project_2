package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.UserDto;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;

@Service
public class UserControllerMethodsService {
    public UserDto authorization(UserDto userDto, String key, String name, String password)
    {
        long duration = Duration.between(LocalTime.now(), userDto.getEndValidityOfUuid()).toHours();
        if (duration >= 1)
            userDto.setBlocked(true);
        if ((!(userDto.isBlocked())) && key.equals(userDto.getUuid()) && name.equals(userDto.getLogin()) && password.equals(userDto.getPassword())) {
            return new UserDto();

        } else {
            userDto.setBlocked(true);
            return new UserDto();

        }
    }
    public UserDto changeKey(UserDto userDto, String name, String password) {
        if (userDto.isBlocked() && name.equals(userDto.getLogin()) && password.equals(userDto.getPassword())) {
            userDto.setUuid(UUID.randomUUID().toString());
            userDto.setBeginValidityOfUuid(LocalTime.now());
            userDto.setEndValidityOfUuid(userDto.getBeginValidityOfUuid().plusHours(1));
            userDto.setBlocked(false);
        }
        return new UserDto();
    }
    public void createUser(UserDto userDto)
    {
        userDto.setUuid(UUID.randomUUID().toString());
        userDto.setBeginValidityOfUuid(LocalTime.now());
        userDto.setEndValidityOfUuid(userDto.getBeginValidityOfUuid().plusHours(1));
        userDto.setBlocked(false);
    }
}
