package com.gamedev.gamedevproper.service;

import com.gamedev.gamedevproper.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    

}
