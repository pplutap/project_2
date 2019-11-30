package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    UserMapper userMapper;

    public UserDto getUser(Long userId) throws EntityNotFoundException {
        Optional<User> user = repository.findOrThrow(userId);
        return userMapper.mapToUserDto(user.get());
    }

    public User saveUser(UserDto userDto) {
        return repository.save(userMapper.mapToUser(userDto));
    }

    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }

    public UserDto blockUser(Long userId) throws EntityNotFoundException {
        Optional<User> user = repository.findOrThrow(userId);
        User userToBlock = user.get();

        //userToBlock.setBlocked();
        //TODO: Po rozpisaniu encji, zostanie to odkomentowane.

        return userMapper.mapToUserDto(userToBlock);
}

    public Long getUniqueKey(Long userId, String userName) throws EntityNotFoundException {
        Optional<User> user = repository.findOrThrow(userId);
        User userForKey = user.get();
//        if (userForKey.getUserName().equals(userName)) {
//            Long randomKey = new Random().nextLong();
//        return userId + randomKey;
//        } else throw new EntityNotFoundException(); // choć powinnien być chyba nowy błąd UserNotAuthorizedExeption ?
        //TODO: jw

        return 0L;

    }
}
