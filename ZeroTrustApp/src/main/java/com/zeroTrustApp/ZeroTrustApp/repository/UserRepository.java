package com.zeroTrustApp.ZeroTrustApp.repository;


import com.zeroTrustApp.ZeroTrustApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);
}