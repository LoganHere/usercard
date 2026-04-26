package com.loganhere.usercard.repository;

import com.loganhere.usercard.dto.User;
import com.loganhere.usercard.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Long, User> storage = new HashMap<>();

    private long currentId;

    public UserRepository(@Value("${usercard.id.start:0}") long startId) {
        this.currentId = startId;
    }

    public User save(User user) {
        currentId++;
        user.setId(currentId);
        storage.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        if (id == null) {
            throw new NullPointerException("Id не может быть пустым");
        }
        if (!storage.containsKey(id)) {
            throw new UserNotFoundException("Такого Id не существует");
        }
        return storage.get(id);
    }

    public boolean delete(Long id) {
        if (id == null) {
            throw new NullPointerException("Id не может быть пустым");
        }
        User removedUser = storage.remove(id);
        return removedUser != null;
    }

    public User findByEmail(String email) {
        for (User user : storage.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
