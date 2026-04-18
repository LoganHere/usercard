package com.loganhere.usercard;

import com.loganhere.usercard.emailvalidation.EmailValidateRequest;
import com.loganhere.usercard.emailvalidation.EmailValidationClient;
import com.loganhere.usercard.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Long, User> storage = new HashMap<>();
    private final EmailValidationClient emailValidationClient;

    private long currentId = 0L;

    public UserRepository(EmailValidationClient emailValidationClient) {
        this.emailValidationClient = emailValidationClient;
    }

    public User save(User user) {
        if (user.getEmail() == null) {
            throw new NullPointerException("Email не может быть пустым");
        }

        EmailValidateRequest request = new EmailValidateRequest();
        request.setEmail(user.getEmail());
        if (!emailValidationClient.validateEmail(request).isValid()) {
            throw new IllegalArgumentException("Email не прошёл валидацию");
        }

        for (User existingUser : storage.values()) {
            if (existingUser.getEmail().equals(user.getEmail())) {
                throw new IllegalArgumentException("Email уже существует");
            }
        }
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
}
