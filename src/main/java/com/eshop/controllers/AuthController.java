package com.eshop.controllers;

import com.eshop.model.AuthorizedUser;
import com.eshop.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthorizedUser login(User validUser) {

        return null;
    }
//    public JSONObject login(@RequestBody User requestUser, HttpServletResponse response) throws IOException {
//        User user = userRepository.findByUsername(requestUser.getUsername());
//
//        if (user != null && user.getPassword().equals(requestUser.getPassword())) {
//            String token = tokenServiceImpl.allocateToken(user.getUsername());
//        } else {
//            response.sendError(401);
//        }
//        return new JSONObject("{}");
//    }

}

