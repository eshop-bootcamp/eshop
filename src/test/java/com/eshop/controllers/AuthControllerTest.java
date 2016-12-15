package com.eshop.controllers;

import com.eshop.model.AuthorizedUser;
import com.eshop.model.User;
import com.eshop.services.UserService;
import com.eshop.services.TokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.hamcrest.core.Is.is;


import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private UserService userService;

    @Mock
    private TokenService tokenService;

    @Test
    public void shouldReturnSuccessPayloadGivenValidUser() throws Exception {
        User validUser = new User("username", "password");
        AuthorizedUser expectedAuthorizedUser = new AuthorizedUser("SomeToken", validUser);

        when(userService.validateUser(validUser)).thenReturn(true);
        when(tokenService.allocateToken(validUser.getUsername())).thenReturn("SomeToken");

        ResponseEntity successResponse = authController.login(validUser);

        assertThat(successResponse.getBody(), is(expectedAuthorizedUser));
        assertThat(successResponse.getStatusCode(), is(HttpStatus.OK));
    }



    @Test
    public void shouldReturnErrorPayloadWhenAuthenticationFails() {
        User invalidUser = new User("Username", "IncorrectPassword");

        UserService userService = mock(UserService.class);
        when(userService.validateUser(invalidUser)).thenReturn(false);

        ResponseEntity errorResponse = authController.login(invalidUser);

        assertThat(errorResponse.getBody(), is(AuthController.USERNAME_AND_REQUEST_DOES_NOT_MATCH));
        assertThat(errorResponse.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
    }
}