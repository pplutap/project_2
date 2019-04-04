package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.UserOwn;
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

    public List<UserOwn> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserOwn> getUserById(final Long id) {
        return repository.findById(id);
    }

    public void delete(final long id) {
        repository.delete(id);
    }

    public UserOwn generateKey(final UserOwn userOwn) {
        userOwn.setUuid(UUID.randomUUID().toString());
        userOwn.setBeginValidityOfUuid(LocalTime.now());
        userOwn.setEndValidityOfUuid(userOwn.getBeginValidityOfUuid().plusHours(1));
        userOwn.setBlocked(false);
        return repository.save(userOwn);
    }

    public UserOwn keyDeliveryProcessIsPossible(final UserOwn userOwn, String keyProvided, String name, String password) {
        long duration = Duration.between(LocalTime.now(), userOwn.getEndValidityOfUuid()).toHours();
        if (duration >= 1)
            userOwn.setBlocked(true);
        if ((!(userOwn.getIsBlocked())) && keyProvided.equals(userOwn.getUUID()) && name.equals(userOwn.getLogin()) && password.equals(userOwn.getPassword())) {
            return repository.save(userOwn);

        } else {
            userOwn.setBlocked(true);
            return repository.save(userOwn);

        }

    }

    public UserOwn changeKey(final UserOwn user, String name, String password) {
        if (user.getIsBlocked() && name.equals(user.getLogin()) && password.equals(user.getPassword()))
            return generateKey(user);
        else
            return repository.save(user);
    }

}
