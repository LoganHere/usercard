package com.loganhere.usercard.service;

import com.loganhere.usercard.client.EmailValidationClient;
import com.loganhere.usercard.dto.EmailValidateRequest;
import com.loganhere.usercard.dto.User;
import com.loganhere.usercard.properties.UserCardProperties;
import com.loganhere.usercard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmailValidationClient emailValidationClient;
    private final UserCardProperties userCardProperties;

    public User createUser(User user) {
        if (user.getEmail() == null) {
            throw new NullPointerException(userCardProperties.getNullException());
        }

        EmailValidateRequest request = new EmailValidateRequest();
        request.setEmail(user.getEmail());
        if (!emailValidationClient.validateEmail(request).isValid()) {
            throw new IllegalArgumentException(userCardProperties.getInvalid());
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException(userCardProperties.getDuplicate());
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
