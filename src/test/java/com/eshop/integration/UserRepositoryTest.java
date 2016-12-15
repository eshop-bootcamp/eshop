package com.eshop.integration;

import com.eshop.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() throws JsonProcessingException {
//        Buyer buyer = new Buyer();
//        buyer.setUsername("User1");
//        buyer.setPassword("Passw1");
//        buyer.setEmailid("User1@tw.com");
//        buyer.setMobile(Long.valueOf(1234567890));
//        buyer.setAddress("Pune");
//        buyer.setName("User1 Full Name");
//        buyer.setGender(Gender.Male);
//
////        ObjectMapper mapper = new ObjectMapper();
////        System.out.println(mapper.writeValueAsString(buyer));
//        assertNotNull(userRepository.save(buyer));
//
//        assertNotNull(buyer.getId());
//        assertTrue(buyer.getUsername()=="User1");
//        assertTrue(buyer.getPassword() == "Passw1");
//        assertTrue(buyer.getEmailid() == "User1@tw.com");
//        assertTrue(buyer.getMobile().equals(Long.valueOf(1234567890)));
//        assertTrue(buyer.getAddress() == "Pune");
//        assertTrue(buyer.getName() == "User1 Full Name");
//        assertTrue(buyer.getGender().equals(Gender.Male));
    }


}
