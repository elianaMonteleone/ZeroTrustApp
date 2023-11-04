package com.zeroTrustApp.ZeroTrustApp.repository;

import com.zeroTrustApp.ZeroTrustApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //User findByUsername(String username);
}