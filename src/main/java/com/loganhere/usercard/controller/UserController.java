package com.loganhere.usercard.controller;

import com.loganhere.auto_log_starter.AutoLog;
import com.loganhere.auto_log_starter.LogLevel;
import com.loganhere.usercard.dto.User;
import com.loganhere.usercard.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    @AutoLog(value = "Creating user", level = LogLevel.INFO)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User saved = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    @AutoLog(value = "User finding", level = LogLevel.INFO)
    public ResponseEntity<User> getUser(@Positive @PathVariable Long id) {
        User saved = userService.getUser(id);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    @AutoLog(value = "Deleting user", level = LogLevel.INFO)
    public ResponseEntity<Void> deleteUser(@Positive @PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);

        if (!deleted) {
            throw new RuntimeException("User not found for deletion, id: " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
