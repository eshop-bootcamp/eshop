package com.eshop.services;


import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final static String SECRET = "Do not even try to hack me";
    private org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();


    public String allocateToken(String extendedInformation) {

        String data = extendedInformation + ":" + SECRET;
        String encodedString = base64.encodeAsString(data.getBytes());
        return new String(extendedInformation + "-" + encodedString);
    }

    public boolean verifyToken(String token) {
        if (token == null) {
            return false;
        }
        String[] tokenParams  = token.split("-");

        String assertAgainst = tokenParams[0];

        String decoded = new String(base64.decode(tokenParams[1]));
        String[] decodedPayLoads = decoded.split(":");

        String secret = decodedPayLoads[1];
        String value = decodedPayLoads[0];

        return (secret.equals(SECRET) && assertAgainst.equals(value));
    }
}
