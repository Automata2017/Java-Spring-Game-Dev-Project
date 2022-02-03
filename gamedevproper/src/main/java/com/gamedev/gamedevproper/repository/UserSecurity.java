package com.gamedev.gamedevproper.repository;

import com.gamedev.gamedevproper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecurity extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String userEmailAddress);

    User findUserByEmailAddress(String userEmailAddress);
}
