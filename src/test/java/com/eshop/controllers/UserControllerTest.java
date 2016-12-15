package com.eshop.controllers;

import com.eshop.model.Buyer;
import com.eshop.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService service;

    @Test
    public void testBuyerWithMandatoryFields() {
        Buyer buyer = new Buyer("John", "Pass123");
        when(service.register(buyer)).thenReturn(new ResponseEntity(HttpStatus.CREATED));
        ResponseEntity response = userController.register(buyer);
        assertNotNull(response);
        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
    }
}
