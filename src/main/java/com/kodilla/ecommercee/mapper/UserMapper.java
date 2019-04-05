package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.UserDto;
import com.kodilla.ecommercee.domainTest.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getBirthDate(),
                userDto.getAdress(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.isBlocked(),
                userDto.getUuid(),
                userDto.getBeginValidityOfUuid(),
                userDto.getEndValidityOfUuid());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getAddress(),
                user.getLogin(),
                user.getPassword(),
                user.isBlocked(),
                user.getUuid(),
                user.getBeginValidityOfUuid(),
                user.getEndValidityOfUuid());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getFirstName(), t.getLastName(), t.getBirthDate(), t.getAddress(), t.getLogin(), t.getPassword(), t.isBlocked(), t.getUuid(), t.getBeginValidityOfUuid(), t.getEndValidityOfUuid()))
                .collect(Collectors.toList());
    }


}



