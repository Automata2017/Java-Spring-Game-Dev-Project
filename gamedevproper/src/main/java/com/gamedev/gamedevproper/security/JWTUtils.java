package com.gamedev.gamedevproper.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    

}
