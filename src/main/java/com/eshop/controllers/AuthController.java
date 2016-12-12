package com.eshop.controllers;

import com.eshop.models.User;
import com.eshop.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
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
