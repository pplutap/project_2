package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.UserNotFoundException;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    public User blockUser(Long userId) throws UserNotFoundException {
        UserDto userToBlockDto = userMapper.mapToUserDto(getUser(userId).orElseThrow(UserNotFoundException::new));
        userToBlockDto.setIsBlocked(true);
        User userToBlock = userMapper.mapToUser(userToBlockDto);
        return saveUser(userToBlock);
    }
}
