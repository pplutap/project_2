package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {

    public User mapToUser(UserDto userDto, Cart cart, List<Order> orders) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getRole(),
                userDto.isStatus(),
                userDto.getUserKey(),
                cart,
                orders
        );
    }

    public UserDto mapToUserDto(User user, CartDto cartDto, List<Long> ordersIdList) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.isStatus(),
                user.getUserKey(),
                user.getCart().getCartId(),
                ordersIdList
        );
    }
}
