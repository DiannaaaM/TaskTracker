package com.TaskTracker.TaskTracker.controller;

import com.TaskTracker.TaskTracker.model.User;
import com.TaskTracker.TaskTracker.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helloPaage")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body( userService.createUser(user) );
    }

    @GetMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) throws BadRequestException {
        return userService.verifyUser( username, password );
    }
}
