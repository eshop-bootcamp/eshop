package com.eshop.service;

import com.eshop.model.User;
import org.springframework.http.HttpStatus;

public class AuthService {

    private static AuthService instance;

    private AuthService() {

    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public String registerUser(User user) {

        return HttpStatus.OK.toString();
    }
}
