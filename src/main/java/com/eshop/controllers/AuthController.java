package com.eshop.controllers;

import com.eshop.model.AuthorizedUser;
import com.eshop.model.User;
import com.eshop.services.UserService;
import com.eshop.services.TokenService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    public static final String USERNAME_AND_REQUEST_DOES_NOT_MATCH = "Username and Request does not match";

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) {

        if(userService.validateUser(user)){
            String token = tokenService.allocateToken(user.getUsername());
            AuthorizedUser authorizedUser = new AuthorizedUser(token, user);
            return ResponseEntity.ok(authorizedUser);
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(USERNAME_AND_REQUEST_DOES_NOT_MATCH);
        }
    }

}

