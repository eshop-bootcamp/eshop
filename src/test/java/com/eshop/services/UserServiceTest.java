package com.eshop.services;

import com.eshop.model.Buyer;
import com.eshop.model.User;
import com.eshop.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
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
        //when(userRepositoryCustom.isEmailUnique(buyer.getEmailId())).thenReturn(true);
        //when(userRepositoryCustom.isUserNameUnique(buyer.getUsername())).thenReturn(true);

        when(userRepository.save(buyer)).thenReturn(buyer);
        ResponseEntity response = userService.register(buyer);
        assertNotNull(response);
        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
    }

    @Test
    public void testBuyerIsNotCreatedWithInValidParameters() {

        User buyer = new Buyer("John", "Pass123");
        //when(userRepositoryCustom.isEmailUnique(buyer.getEmailId())).thenReturn(false);
        // when(userRepositoryCustom.isUserNameUnique(buyer.getUsername())).thenReturn(false);
        ResponseEntity response = userService.register(buyer);
        assertNotNull(response);
        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
    }

@Test
    public void shouldReturnTrueWhenUserIsValid(){
        User user = new Buyer("John", "Pass123");
        when(userRepository.findByUsername("John")).thenReturn(user);
        assertEquals(user, userService.validateUser(user));
    }
}
