package com.eshop.service;

import com.eshop.controllers.AuthController;
import com.eshop.models.User;
import com.sun.tools.internal.ws.wsdl.document.http.HTTPConstants;
import org.json.HTTP;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class ResgistrationServiceTest {

    @Test
    public void whenValidUserParamProvidedRegiterTheUser() {
        User user = new User("username", "password");
        Assert.assertEquals(HttpStatus.OK.toString(), AuthService.getInstance().registerUser(user));
    }

}
