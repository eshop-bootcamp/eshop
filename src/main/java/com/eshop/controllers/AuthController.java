package com.eshop.controllers;

import com.eshop.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AuthController {


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    void register(@RequestBody User user, HttpServletResponse response) throws IOException {

        response.setStatus(200);
        response.getWriter().write("{\n" +
                "\t\"Status\": \"Good\",\n"+
                "}");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String testApi(){
        return "HelloWorld Dhiraj & Jindo";
    }


}
