package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.security.UsersDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDbService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    public User getOriginalUser(Long id) throws UserNotFoundException{
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User createUser(UserDto userDto) {
        User user = userMapper.mapToPureUser(userDto);
        user.setRole("USER");
        String encryptedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPwd);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UsersDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " doesn't exist"));
    }
}
