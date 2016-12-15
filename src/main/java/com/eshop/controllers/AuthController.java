package com.eshop.controllers;

import com.eshop.model.AuthorizedUser;
import com.eshop.model.User;
import com.eshop.services.TokenService;
import com.eshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
public class AuthController {
    public static final String USERNAME_AND_REQUEST_DOES_NOT_MATCH = "username and password does not match";

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) {
        try{
            User validatedUser = userService.validateUser(user);
            String token = tokenService.allocateToken(Arrays.asList(user.getUsername(), user.getUserType()));
            return ResponseEntity.ok(new AuthorizedUser(token, user));
        }
        catch (UsernameNotFoundException e){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> content = new LinkedHashMap<>();
            content.put("message", USERNAME_AND_REQUEST_DOES_NOT_MATCH);
            return new ResponseEntity(content, httpHeaders, HttpStatus.UNAUTHORIZED);
        }

    }

}

