package com.zeroTrustApp.ZeroTrustApp.service;


import com.zeroTrustApp.ZeroTrustApp.model.User;
import com.zeroTrustApp.ZeroTrustApp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceNew {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User registerNewUserAccount(User user) {
        if (emailExists(user.getEmail())) {
            // Throw an exception or handle it accordingly
            throw new RuntimeException("There is an account with that email address: " + user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    // Authentication method if you're not using Spring Security's built-in mechanisms.
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // User can be authenticated
            return true;
        } else {
            // User authentication failed
            return false;
        }
    }
}
