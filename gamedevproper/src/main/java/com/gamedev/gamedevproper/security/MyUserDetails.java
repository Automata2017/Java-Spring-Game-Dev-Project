package com.gamedev.gamedevproper.security;

import com.gamedev.gamedevproper.model.User;

public class MyUserDetails {

    private User user;
    private String userName;
    private String password;
    private String emailAddress;

    public MyUserDetails(User user) {
        this.user = user;
    }

}
