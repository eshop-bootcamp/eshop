package com.eshop.model;

public class AuthorizedUser {
    private final String randomToken;
    private final User validUser;

    public AuthorizedUser(String randomToken, User validUser) {
        this.randomToken = randomToken;
        this.validUser = validUser;
    }



}
