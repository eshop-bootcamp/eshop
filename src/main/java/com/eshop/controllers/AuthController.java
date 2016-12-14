package com.eshop.controllers;

import com.eshop.model.User;
import com.eshop.repositories.UserRepository;
import com.eshop.services.implementation.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    TokenServiceImpl tokenServiceImpl = new TokenServiceImpl();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User requestUser, HttpServletResponse response) {
        User user = userRepository.findByUsername(requestUser.getUsername());
        if (user != null && user.getPassword().equals(requestUser.getPassword())) {
            String token = tokenServiceImpl.allocateToken(user.getUsername());
            response.setHeader("auth-header", token);
            return "Success";
        } else {
            return "Failed";
        }

    }

}

