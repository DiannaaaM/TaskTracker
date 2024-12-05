package com.TaskTracker.TaskTracker.service;

import com.TaskTracker.TaskTracker.model.User;
import com.TaskTracker.TaskTracker.repository.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        Optional<User> existingUser = Optional.ofNullable( userRepository.findByUsername( user.getUsername() ) );
        if (existingUser.isPresent()) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        return userRepository.save(user);
    }

    public User verifyUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Неверный пароль");
        }

        return user;
    }

}
