package com.eshop.controllers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AuthControllerTest {

    @Test
    public void testLogin() throws Exception {
        AuthController authController = new AuthController();
        assertThat(authController.login(), is("Authenticated!"));
    }

}