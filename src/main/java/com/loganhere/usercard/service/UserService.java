package com.loganhere.usercard.service;

import com.loganhere.usercard.client.EmailValidationClient;
import com.loganhere.usercard.dto.EmailValidateRequest;
import com.loganhere.usercard.dto.User;
import com.loganhere.usercard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmailValidationClient emailValidationClient;

    public User createUser(User user) {
        if (user.getEmail() == null) {
            throw new NullPointerException("Email не может быть пустым");
        }

        EmailValidateRequest request = new EmailValidateRequest();
        request.setEmail(user.getEmail());
        if (!emailValidationClient.validateEmail(request).isValid()) {
            throw new IllegalArgumentException("Email не прошёл валидацию");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email уже существует");
        }

        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long id) {
        return userRepository.delete(id);
    }
}
