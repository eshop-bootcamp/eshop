package com.eshop.controllers;

import com.eshop.model.AuthorizedUser;
import com.eshop.model.Buyer;
import com.eshop.model.User;
import com.eshop.services.TokenService;
import com.eshop.services.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
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

    @Mock
    private HttpServletResponse httpServletResponse;

    @Test
    public void shouldReturnSuccessPayloadGivenValidUser() throws Exception {
        User validUser = new Buyer("username", "password");
        AuthorizedUser expectedAuthorizedUser = new AuthorizedUser("SomeToken", validUser);
        User userReturnedFromValidation = new Buyer("username", "password");
        when(userService.validateUser(validUser)).thenReturn(userReturnedFromValidation);
        when(tokenService.allocateToken(any(List.class))).thenReturn("SomeToken");

        ResponseEntity successResponse = authController.login(validUser);

        assertThat(successResponse.getBody(), is(expectedAuthorizedUser));
        assertThat(successResponse.getStatusCode(), is(HttpStatus.OK));
    }



@Test
@Ignore
    public void shouldReturnErrorPayloadWhenAuthenticationFails() {
        Buyer invalidUser = new Buyer("Username", "IncorrectPassword");
        UserService userService = mock(UserService.class);
        when(userService.validateUser(invalidUser)).thenThrow(UsernameNotFoundException.class);

        ResponseEntity errorResponse = authController.login(invalidUser);

        assertThat(errorResponse.getBody().toString(), is("{message="+AuthController.USERNAME_AND_REQUEST_DOES_NOT_MATCH+"}"));
        assertThat(errorResponse.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
    }
}