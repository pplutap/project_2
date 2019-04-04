package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.UserDto;
import com.kodilla.ecommercee.UserOwn;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public UserOwn mapToTask(final UserDto userDto) {
        return new UserOwn(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword(),
        userDto.getUuid(),
        userDto.getIsBlocked(),
        userDto.getBeginValidityOfUuid(),
        userDto.getEndValidityOfUuid());
    }

    public UserDto mapToUserDto(final UserOwn user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getUUID(),
                user.getIsBlocked(),
                user.getBeginValidityOfUuid(),
                user.getEndValidityOfUuid());

    }

    public List<UserDto> mapToTaskDtoList(final List<UserOwn> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getLogin(), t.getPassword(), t.getUUID(), t.getIsBlocked(), t.getBeginValidityOfUuid(), t.getEndValidityOfUuid()))
                .collect(Collectors.toList());
    }


}



