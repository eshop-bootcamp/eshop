package com.eshop.model;

public class AuthorizedUser {
    private final String token;
    private final User validUser;

    public AuthorizedUser(String token, User validUser) {
        this.token = token;
        this.validUser = validUser;
    }

    public String getToken() {
        return token;
    }

    public User getValidUser() {
        return validUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorizedUser that = (AuthorizedUser) o;

        if (!token.equals(that.token)) return false;
        return validUser.equals(that.validUser);
    }

    @Override
    public int hashCode() {
        int result = token.hashCode();
        result = 31 * result + validUser.hashCode();
        return result;
    }
}
