package com.loganhere.usercard;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    public final Map<Long, User> storage = new HashMap<>();
    private long currentId = 1L;

    public User save(User user) {
        if (user.getEmail() == null) {
            throw new NullPointerException("Email не может быть пустым");
        }
        for (User existingUser : storage.values()) {
            if (existingUser.getEmail().equals(user.getEmail())) {
                throw new IllegalArgumentException("Email уже существует");
            }
        }
        user.setId(currentId);
        currentId++;
        storage.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        if (id == null) {
            throw new NullPointerException("Id не может быть пустым");
        }
        if (!storage.containsKey(id)) {
            throw new IllegalArgumentException("Такого Id не существует");
        }
        return storage.get(id);
    }

    public boolean delete(Long id) {
        if (id == null) {
            throw new NullPointerException("Id не может быть пустым");
        }
        if (!storage.containsKey(id)) {
            throw new IllegalArgumentException("Такого Id не существует");
        }
        storage.remove(id);
        return true;
    }
}
