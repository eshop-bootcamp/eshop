package com.eshop.services;

import com.eshop.model.Buyer;
import com.eshop.model.User;
import com.eshop.repositories.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testBuyerIsCreatedWithValidParameters() {
        User buyer = new Buyer("John", "Pass123");
        when(userRepository.save(buyer)).thenReturn(buyer);
        ResponseEntity response = userService.register(buyer);
        assertNotNull(response);
        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
    }

    @Test
    public void testBuyerIsNotCreatedWithInValidParameters() {
        User buyer = new Buyer("John", "Pass123");
        ResponseEntity response = userService.register(buyer);
        assertNotNull(response);
        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
    }

    @Test
    public void shouldReturnFalseWhenUserIsNotValid() {
        User user = new User("John", "Pass123");
        when(userRepository.findByUsername("John12")).thenReturn(null);
        assertFalse(userService.validateUser(user));
    }

    @Test
    public void shouldReturnTrueWhenUserIsValid(){
        User user = new User("John", "Pass123");
        when(userRepository.findByUsername("John")).thenReturn(user);
        assertTrue(userService.validateUser(user));
    }
}
