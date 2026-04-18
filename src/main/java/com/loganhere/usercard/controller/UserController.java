package com.loganhere.usercard.controller;

import com.loganhere.usercard.dto.User;
import com.loganhere.usercard.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        log.info("User is creating, user - {}", user);
        User saved = userService.createUser(user);
        log.info("User create, user - {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@Positive @PathVariable Long id) {
        log.debug("User is finding by id, id - {}", id);
        User saved = userService.getUser(id);
        log.debug("User found by id, id - {}", id);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@Positive @PathVariable Long id) {
        log.info("User is deleting by id, id - {}", id);
        boolean deleted = userService.deleteUser(id);

        if (deleted) {
            log.info("User deleted by id, id - {}", id);
        } else {
            log.warn("User NOT deleted by id, id - {}", id);
        }
        return ResponseEntity.noContent().build();
    }
}
