package com.eshop.controllers;

import com.eshop.model.AuthorizedUser;
import com.eshop.model.User;
import com.eshop.repositories.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AuthControllerTest {

    @Mock
    private UserRepository userRepository;

    @Test @Ignore
    public void shouldReturnSuccessPayloadGivenValidUser() throws Exception {
        AuthController authController = new AuthController();
        User validUser = new User("username", "password");

        AuthorizedUser authorizedUser = authController.login(validUser);
        when(userRepository.findByUsername(validUser.getUsername())).thenReturn(validUser);
        verify(userRepository.findByUsername(validUser.getUsername()));
        AuthorizedUser expectedAuthorizedUser = new AuthorizedUser("randomToken", validUser);
        assertThat(authorizedUser, is(expectedAuthorizedUser));

    }


}