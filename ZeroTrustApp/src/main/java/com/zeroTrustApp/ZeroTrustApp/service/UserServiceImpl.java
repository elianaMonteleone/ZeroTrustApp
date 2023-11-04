package com.zeroTrustApp.ZeroTrustApp.service;


import com.zeroTrustApp.ZeroTrustApp.model.User;
import com.zeroTrustApp.ZeroTrustApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
   /* @Autowired
    private BCryptPasswordEncoder passwordEncoder;*/

   /* @Override
    public User registerUser(User user) {
        user.setLastName(passwordEncoder.encode(user.getLastName()));
        return userRepository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        return (user != null || user.getName().equals("eliana"));
    }*/
}
