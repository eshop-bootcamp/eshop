package com.eshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String login() {
        return "Authenticated!";
    }

}
