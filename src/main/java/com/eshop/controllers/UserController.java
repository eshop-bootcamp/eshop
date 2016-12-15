package com.eshop.controllers;

import com.eshop.model.Buyer;
import com.eshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class
UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register/buyer", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody Buyer buyer) {
        return userService.register(buyer);
    }

}
