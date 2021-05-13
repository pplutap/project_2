package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDbService implements UserDetailsService {

    private final UserRepository userRepository;
    private final CartDbService cartDbService;
    private OrderDbService orderDbService;
    private final UserMapper userMapper;

    public User getOriginalUser(Long id) throws UserNotFoundException{
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public boolean isKeyAssignedToUser(Long key) {
        List<User> users = userRepository.findAll();
        return users.stream()
                .anyMatch(user -> user.getUserKey() == key);
    }

    public User createUser(UserDto userDto) throws CartNotFoundException {
        Cart cart = cartDbService.getOriginalCart(userDto.getCartId());
        List<Order> orders = orderDbService.getOrdersBelongToUser(userDto.getId());
        User user = userMapper.mapToUser(userDto, cart, orders);
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UsersDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " doesn't exist"));
    }
}
