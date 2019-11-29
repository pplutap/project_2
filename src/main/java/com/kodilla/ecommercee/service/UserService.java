package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    UserMapper userMapper;

    public UserDto getUser(Long userId) {
        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        return userMapper.mapToUserDto(user);
    }

    public User saveUser(UserDto userDto) {
        return repository.save(userMapper.mapToUser(userDto));
    }

    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }

    public UserDto blockUser(Long userId) {
        User userToBlock = repository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        userToBlock.setBlocked(true);
        return userMapper.mapToUserDto(userToBlock);
    }
}
