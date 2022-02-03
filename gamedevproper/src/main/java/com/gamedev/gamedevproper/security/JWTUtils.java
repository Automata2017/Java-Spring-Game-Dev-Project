package com.gamedev.gamedevproper.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTUtils {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        final String AuthorizationHeader = httpServletRequest.getHeader("Authorization");

        String username = null;
        String jwt = null;
        if (AuthorizationHeader != null && AuthorizationHeader.startsWith("Bearer ")) {
            jwt = AuthorizationHeader.substring(7);
            username = jwtUtils.extractUsername(jwt);
        }



}
