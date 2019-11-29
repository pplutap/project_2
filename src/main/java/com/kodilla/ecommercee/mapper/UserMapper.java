package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.isBlocked());
    }

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.isBlocked());
    }
}