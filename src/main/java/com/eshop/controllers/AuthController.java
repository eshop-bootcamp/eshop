package com.eshop.controllers;

import com.eshop.models.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthController {


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    String register(@RequestBody User user) throws IOException {

//        return ("{\n" +
//                "\t\"Status\": \"Good\",\n"+
//                "}");
        return ("Hello World");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String testApi(){
        return "HelloWorld Dhiraj & Jindo";
    }


}
