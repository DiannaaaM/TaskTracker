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
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            if (user == null || user.getUsername() == null || user.getPassword() == null) {
                return ResponseEntity.badRequest().body("Имя пользователя и пароль не могут быть пустыми");
            }
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok("Пользователь успешно зарегистрирован: " + createdUser.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Ошибка при создании пользователя: " + e.getMessage());
        }
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                return ResponseEntity.badRequest().body("Имя пользователя и пароль не могут быть пустыми");
            }
            User user = userService.verifyUser(username, password);
            return ResponseEntity.ok("Добро пожаловать, " + user.getUsername());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Ошибка при входе: " + e.getMessage());
        }
    }

}
