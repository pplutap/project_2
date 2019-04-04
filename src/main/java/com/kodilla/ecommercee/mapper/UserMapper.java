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
                userDto.getUsername(),
                userDto.getPassword());
    }

    public UserDto mapToUserDto(final UserOwn user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getIsBlocked());

    }

    public List<UserDto> mapToTaskDtoList(final List<UserOwn> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getLogin(), t.getPassword(), t.getIsBlocked()))
                .collect(Collectors.toList());
    }


}



