package com.TaskTracker.TaskTracker.service;

import com.TaskTracker.TaskTracker.model.User;
import com.TaskTracker.TaskTracker.repository.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User verifyUser(String username, String password) throws BadRequestException {
        User user = userRepository.findByUsername(username);
        if (!user.getPassword().equals(password)) {
            throw new BadRequestException("Wrong password");
        } else {
            return user;
        }
    }
}
