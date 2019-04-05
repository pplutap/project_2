package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domainTest.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DbUserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(final Long id) {
        return repository.findById(id);
    }

    public void deleteById(final long id) {
        repository.deleteById(id);
    }

    public User generateKey(final User user) {
        user.setUuid(UUID.randomUUID().toString());
        user.setBeginValidityOfUuid(LocalTime.now());
        user.setEndValidityOfUuid(user.getBeginValidityOfUuid().plusHours(1));
        user.setBlocked(false);
        return repository.save(user);
    }

    public User keyDeliveryProcessIsPossible(final User user, String keyProvided, String name, String password) {
        long duration = Duration.between(LocalTime.now(), user.getEndValidityOfUuid()).toHours();
        if (duration >= 1)
            user.setBlocked(true);
        if ((!(user.isBlocked())) && keyProvided.equals(user.getUuid()) && name.equals(user.getLogin()) && password.equals(user.getPassword())) {
            return repository.save(user);

        } else {
            user.setBlocked(true);
            return repository.save(user);

        }

    }

    public User changeKey(final User user, String name, String password) {
        if (user.isBlocked() && name.equals(user.getLogin()) && password.equals(user.getPassword()))
            return generateKey(user);
        else
            return repository.save(user);
    }

}
