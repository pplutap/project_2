package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;

public class UserMapper {
    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserName(),
                user.getUserId(),
                user.isBlocked());
    }

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserName(),
                userDto.getUserId(),
                userDto.isBlocked());
    }
}
