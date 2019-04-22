package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getIsBlocked(),
                userDto.getUserIdKey(),
                getListOrdersWithId(userDto.getOrdersIdList()));
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getIsBlocked(),
                user.getUserIdKey(),
                getListOrderIdFromUser(user.getOrdersList()));
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(u -> new UserDto(u.getUserId(), u.getUserName(), u.getIsBlocked(), u.getUserIdKey(), getListOrderIdFromUser(u.getOrdersList())))
                .collect(Collectors.toList());
    }

    private Order getOrderWithId(Long id) {
        if (id == null || id == 0)
            return null;
        return orderService.getOrder(id).orElse(null);
    }

    private List<Order> getListOrdersWithId(List<Long> ordersId) {
        if (ordersId == null)
            return new ArrayList<>();
        return ordersId.stream()
                .map(this::getOrderWithId)
                .collect(Collectors.toList());
    }

    private Long getIdFromOrder(Order order) {
        try {
            return order.getId();
        } catch (Exception e) {
            return null;
        }
    }

    private List<Long> getListOrderIdFromUser(List<Order> orders) {
        try {
            return orders.stream()
                    .map(this::getIdFromOrder )
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
