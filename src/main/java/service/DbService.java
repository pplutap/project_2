package service;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import repository.UserRepository;

@Service
public class DbService {

    @Autowired
    private UserRepository repository;


    public User saveUser(final User user) {
        return repository.save(user);
    }

    public Optional<User> getUser(final Long id) {
        return repository.findById(id);
    }




}
