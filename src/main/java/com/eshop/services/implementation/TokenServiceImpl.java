package com.eshop.services.implementation;

import com.eshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by akshaybansod on 12/14/16.
 */
public class TokenServiceImpl {

    private final static String SECRET = "Do not even try to hack me";
    @Autowired
    private UserRepository userRepository;
    private org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();

    public String allocateToken(String extendedInformation) {

        String encodedString = base64.encodeAsString(SECRET.getBytes());

        return encodedString;

    }

    public boolean verifyToken(String token) {
        if (token == null) {
            return false;
        }
        String secret = new String(base64.decode(token));
        System.out.println(secret);
        return secret.equals(SECRET);

    }
}
